package LowLevelDesign.Splitwise.Controllers;

import LowLevelDesign.Splitwise.Models.Expense;
import LowLevelDesign.Splitwise.Models.ExpenseSplitType;
import LowLevelDesign.Splitwise.Models.Group;
import LowLevelDesign.Splitwise.Models.User;
import LowLevelDesign.Splitwise.Services.ExpenseService;
import LowLevelDesign.Splitwise.Split.Split;

import java.math.BigDecimal;
import java.util.List;

public class ExpenseController {

    private final ExpenseService expenseService;

    public ExpenseController(ExpenseService expenseService) {
        this.expenseService = expenseService;
    }

    public Expense addExpense(
            ExpenseSplitType type,
            Group group,
            BigDecimal amount,
            User paidBy,
            List<Split> splits
    ) {

        return expenseService.addExpense(
                type,
                group,
                amount,
                paidBy,
                splits
        );
    }
}