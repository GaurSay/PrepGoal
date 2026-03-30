package LowLevelDesign.Splitwise.Split;

import java.math.BigDecimal;
import java.util.List;


public class UnequalSplitStrategy implements SplitStrategy {
    @Override
    public void calculateSplits(List<Split> splits, BigDecimal amount) {

        BigDecimal total = BigDecimal.ZERO;

        for (Split split : splits) {
            total = total.add(split.getAmount());
        }

        if (total.compareTo(amount) != 0) {
            throw new RuntimeException("Invalid exact split");
        }
    }
}
