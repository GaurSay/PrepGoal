package LowLevelDesign.Splitwise.Split;

import java.math.BigDecimal;
import java.util.List;


public class PercentageSplitStrategy implements SplitStrategy {

    @Override
    public void calculateSplits(List<Split> splits, BigDecimal amount) {

        double percentTotal = 0;

        for (Split split : splits) {

            PercentSplit ps = (PercentSplit) split;

            percentTotal += ps.getPercent();

            BigDecimal splitAmount =
                    amount.multiply(BigDecimal.valueOf(ps.getPercent()))
                            .divide(BigDecimal.valueOf(100));

            split.setAmount(splitAmount);
        }

        if (percentTotal != 100) {
            throw new RuntimeException("Percent must equal 100");
        }
    }
}