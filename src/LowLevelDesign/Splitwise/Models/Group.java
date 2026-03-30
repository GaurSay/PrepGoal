package LowLevelDesign.Splitwise.Models;

import lombok.Data;
import lombok.Getter;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
@Data
public class Group {

    private final String groupId;
    private final String groupName;

    @Getter
    private final Set<User> members = new HashSet<>();
    private final List<Expense> expenses = new ArrayList<>();

    public Group(String groupId, String groupName) {
        this.groupId = groupId;
        this.groupName = groupName;
    }

    public void addMember(User user) {
        members.add(user);
    }

    public void addExpense(Expense expense) {
        expenses.add(expense);
    }
}
