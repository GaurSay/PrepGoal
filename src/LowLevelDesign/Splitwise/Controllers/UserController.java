package LowLevelDesign.Splitwise.Controllers;

import LowLevelDesign.Splitwise.Models.User;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class UserController {

    private final Map<String, User> users = new HashMap<>();

    public User createUser(String name) {

        String userId = UUID.randomUUID().toString();

        User user = new User(userId, name);

        users.put(userId, user);

        return user;
    }

    public User getUser(String userId) {
        return users.get(userId);
    }

    public Map<String, User> getAllUsers() {
        return users;
    }
}
