package LowLevelDesign.Splitwise.Split;

import LowLevelDesign.Splitwise.Models.User;
import lombok.Setter;

import java.math.BigDecimal;

public class Split {

    private final User user;
    @Setter
    private BigDecimal amount;

    public Split(User user) {
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    public BigDecimal getAmount() {
        return amount;
    }

}