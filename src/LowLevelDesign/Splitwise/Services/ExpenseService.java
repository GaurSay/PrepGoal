package LowLevelDesign.Splitwise.Services;

import LowLevelDesign.Splitwise.Models.Expense;
import LowLevelDesign.Splitwise.Models.ExpenseSplitType;
import LowLevelDesign.Splitwise.Models.Group;
import LowLevelDesign.Splitwise.Models.User;
import LowLevelDesign.Splitwise.Split.Split;
import LowLevelDesign.Splitwise.Split.SplitFactory;
import LowLevelDesign.Splitwise.Split.SplitStrategy;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;
public class ExpenseService {

    private final BalanceService balanceService;
    private  final ExpenseRepository expenseRepository;

    public ExpenseService(BalanceService balanceService) {
        this.balanceService = balanceService;
        expenseRepository = new ExpenseRepository();
    }

    public Expense addExpense(
            ExpenseSplitType type,
            Group group,
            BigDecimal amount,
            User paidBy,
            List<Split> splits
    ) {

        SplitStrategy strategy =
                SplitFactory.getSplitStrategy(type);

        strategy.calculateSplits(splits, amount);

        if (group != null) {

            if (!group.getMembers().contains(paidBy)) {
                throw new RuntimeException("Payer not in group");
            }

            for (Split split : splits) {

                if (!group.getMembers()
                        .contains(split.getUser())) {

                    throw new RuntimeException(
                            "Split user not in group"
                    );
                }
            }
        }

        Expense expense =
                new Expense(
                        UUID.randomUUID().toString(),
                        "Expense",
                        amount,
                        paidBy,
                        type,
                        splits,
                        group!=null ? group.getGroupId() : null
                );

        if (group != null) {
            group.addExpense(expense);
        } else {

            // direct expense → store for both users
            expenseRepository.addExpense(expense);
        }

        balanceService.updateBalances(paidBy, splits);

        return expense;
    }
}