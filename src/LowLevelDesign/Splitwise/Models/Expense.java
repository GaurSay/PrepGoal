package LowLevelDesign.Splitwise.Models;

import LowLevelDesign.Splitwise.Split.Split;
import lombok.Getter;

import java.math.BigDecimal;
import java.util.List;

public class Expense {

    private final String expenseId;
    private final String description;
    private final BigDecimal amount;
    @Getter
    private final User paidBy;
    private final ExpenseSplitType splitType;
    private final List<Split> splits;
    private final String groupId;

    public Expense(
            String expenseId,
            String description,
            BigDecimal amount,
            User paidBy,
            ExpenseSplitType splitType,
            List<Split> splits,
            String groupId
    ) {
        this.expenseId = expenseId;
        this.description = description;
        this.amount = amount;
        this.paidBy = paidBy;
        this.splitType = splitType;
        this.splits = splits;
        this.groupId = groupId;
    }

    public List<Split> getSplits() {
        return splits;
    }
}
