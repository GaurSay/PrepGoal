package LowLevelDesign.Splitwise;

import LowLevelDesign.Splitwise.Controllers.BalanceController;
import LowLevelDesign.Splitwise.Controllers.GroupController;
import LowLevelDesign.Splitwise.Controllers.UserController;
import LowLevelDesign.Splitwise.Models.ExpenseSplitType;
import LowLevelDesign.Splitwise.Models.Group;
import LowLevelDesign.Splitwise.Models.User;
import LowLevelDesign.Splitwise.Services.BalanceService;
import LowLevelDesign.Splitwise.Services.ExpenseService;
import LowLevelDesign.Splitwise.Services.SettlementService;
import LowLevelDesign.Splitwise.Split.Split;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Splitwise {

    UserController userController;
    GroupController groupController;

    BalanceController balanceController;
    BalanceService balanceService = new BalanceService();

    Splitwise(){
        userController = new UserController();
        groupController = new GroupController();
        balanceController = new BalanceController(balanceService);
    }

    public void demo(){

        User u1 = new User("1","Shubham");
        User u2 = new User("2","Rahul");
        User u3 = new User("3","Aman");
        Map<String, User> userMap = new HashMap<>();

        userMap.put(u1.getUserId(), u1);
        userMap.put(u2.getUserId(), u2);
        userMap.put(u3.getUserId(), u3);

        Group group = new Group("g1","Goa Trip");

        group.addMember(u1);
        group.addMember(u2);
        group.addMember(u3);

        BalanceService balanceService =
                new BalanceService();

        ExpenseService expenseService =
                new ExpenseService(balanceService);

        List<Split> splits = new ArrayList<>();

        splits.add(new Split(u1));
        splits.add(new Split(u2));
        splits.add(new Split(u3));

        expenseService.addExpense(
                ExpenseSplitType.EQUAL,
                group,
                new BigDecimal("300"),
                u1,
                splits
        );

        balanceService.showAllBalances(userMap);

        SettlementService settlementService =
                new SettlementService();

        settlementService.settle(
                balanceService.getBalances());

        balanceService.getUserSummary(u1.getUserId());

    }

}
