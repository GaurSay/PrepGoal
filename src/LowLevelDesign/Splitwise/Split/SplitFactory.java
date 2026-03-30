package LowLevelDesign.Splitwise.Split;

import LowLevelDesign.Splitwise.Models.ExpenseSplitType;

public class SplitFactory {

    public static SplitStrategy getSplitStrategy(ExpenseSplitType splitType) {

        return switch (splitType) {
            case EQUAL -> new EqualSplitStrategy();
            case UNEQUAL -> new UnequalSplitStrategy();
            case PERCENTAGE -> new PercentageSplitStrategy();
            default -> null;
        };
    }

}
