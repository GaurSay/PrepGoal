package LowLevelDesign.Splitwise.Services;

import LowLevelDesign.Splitwise.Models.Expense;

import java.util.ArrayList;
import java.util.List;

public class ExpenseRepository {

    private final List<Expense> allExpenses;


    public ExpenseRepository(){
        allExpenses = new ArrayList<>();
    }

    public void addExpense(Expense expense){
        allExpenses.add(expense);
    }

    public List<Expense> getExpenses(){
       return allExpenses;
    }


}
