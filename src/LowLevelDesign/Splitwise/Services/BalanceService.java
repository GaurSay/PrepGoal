package LowLevelDesign.Splitwise.Services;

import LowLevelDesign.Splitwise.Models.User;
import LowLevelDesign.Splitwise.Split.Split;
import lombok.Getter;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Getter
public class BalanceService {

    private final Map<String, Map<String, BigDecimal>> balances =
            new HashMap<>();
    //stores like who I have to pay -like first key is my userId, second is to whom I owe ( or mujhe kise paise dene hai)

    public void updateBalances(User paidBy, List<Split> splits) {

        for (Split split : splits) {

            User user = split.getUser();

            if (user.getUserId().equals(paidBy.getUserId())) continue;

            BigDecimal amount = split.getAmount();

            balances
                    .computeIfAbsent(user.getUserId(), k -> new HashMap<>())
                    .merge(
                            paidBy.getUserId(),
                            amount,
                            BigDecimal::add
                    );
        }
    }


    public void getUserSummary(String userId) {

        BigDecimal totalOwe = BigDecimal.ZERO;
        BigDecimal totalGetBack = BigDecimal.ZERO;

        // what user owes
        if (balances.containsKey(userId)) {

            for (BigDecimal amt : balances.get(userId).values()) {
                totalOwe = totalOwe.add(amt);
            }
        }

        // what others owe user
        for (String other : balances.keySet()) {

            if (balances.get(other).containsKey(userId)) {

                totalGetBack =
                        totalGetBack.add(
                                balances.get(other).get(userId)
                        );
            }
        }

        BigDecimal net = totalGetBack.subtract(totalOwe);

        System.out.println("Total Owe: " + totalOwe);
        System.out.println("Total GetBack: " + totalGetBack);
        System.out.println("Net Balance: " + net);
    }

    public void showAllBalances(Map<String, User> userMap) {

        boolean empty = true;

        for (String userId : balances.keySet()) {

            for (Map.Entry<String, BigDecimal> entry : balances.get(userId).entrySet()) {

                if (entry.getValue().compareTo(BigDecimal.ZERO) > 0) {

                    System.out.println(
                            userMap.get(userId).getUserName()
                                    + " owes " +
                                    userMap.get(entry.getKey()).getUserName()
                                    + " : " +
                                    entry.getValue()
                    );

                    empty = false;
                }
            }
        }

        if (empty) {
            System.out.println("No balances");
        }
    }
}