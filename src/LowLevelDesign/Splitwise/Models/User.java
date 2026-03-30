package LowLevelDesign.Splitwise.Models;

import lombok.Getter;

@Getter
public class User {

    private final String userId;
    private final String userName;

    public User(String userId, String userName) {
        this.userId = userId;
        this.userName = userName;
    }

}
