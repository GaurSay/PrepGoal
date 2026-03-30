package LowLevelDesign.Splitwise.Models;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;


@Data
public class UserExpenseBalanceSheet {

    Map<String, Balance> userVsBalance;
    double totalYourExpense;

    double totalYouOwe;
    double totalYouGetBack;

    public UserExpenseBalanceSheet(){

        userVsBalance = new HashMap<>();
        totalYourExpense = 0;
        totalYouOwe = 0;
        totalYouGetBack = 0;
    }

}
