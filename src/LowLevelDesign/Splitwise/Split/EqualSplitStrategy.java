package LowLevelDesign.Splitwise.Split;

import java.math.BigDecimal;
import java.util.List;

public class EqualSplitStrategy implements SplitStrategy {

    @Override
    public void calculateSplits(List<Split> splits, BigDecimal amount) {

        BigDecimal splitAmount =
                amount.divide(BigDecimal.valueOf(splits.size()));

        for (Split split : splits) {
            split.setAmount(splitAmount);
        }
    }
}
