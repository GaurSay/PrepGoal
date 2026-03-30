package LowLevelDesign.Splitwise.Split;

import java.math.BigDecimal;
import java.util.List;

public interface SplitStrategy {
    void calculateSplits(List<Split> splits, BigDecimal amount);
}
