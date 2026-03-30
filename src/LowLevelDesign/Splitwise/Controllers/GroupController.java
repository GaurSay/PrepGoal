package LowLevelDesign.Splitwise.Controllers;

import LowLevelDesign.Splitwise.Models.Group;
import LowLevelDesign.Splitwise.Models.User;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class GroupController {

    private final Map<String, Group> groups = new HashMap<>();

    public Group createGroup(String name) {

        String groupId = UUID.randomUUID().toString();

        Group group = new Group(groupId, name);

        groups.put(groupId, group);

        return group;
    }

    public void addMember(String groupId, User user) {

        Group group = groups.get(groupId);

        if (group == null) {
            throw new RuntimeException("Group not found");
        }

        group.addMember(user);
    }

    public Group getGroup(String groupId) {
        return groups.get(groupId);
    }
}