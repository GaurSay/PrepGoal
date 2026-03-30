package LowLevelDesign.Splitwise.Controllers;

import LowLevelDesign.Splitwise.Services.BalanceService;

public class BalanceController {

    private final BalanceService balanceService;

    public BalanceController(BalanceService balanceService) {
        this.balanceService = balanceService;
    }

//    public void showAllBalances() {
//        balanceService.showAllBalances();
//    }
}