package LowLevelDesign.Splitwise.Split;

import LowLevelDesign.Splitwise.Models.User;
import lombok.Getter;

@Getter
public class PercentSplit extends Split {

    private final double percent;

    public PercentSplit(User user, double percent) {
        super(user);
        this.percent = percent;
    }

}