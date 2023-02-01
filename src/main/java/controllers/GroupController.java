package controllers;

import exceptions.GroupNameAlreadyExistsException;
import models.Group;
import models.User;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupController {
    // Controller for CRUD operations in the Group
    private Map<String, Group> groups = new HashMap<>();

    public void createGroup(Group group) {
        if (groups.containsKey(group.getGroupName())) {
            throw new GroupNameAlreadyExistsException();
        }
        groups.put(group.getGroupName(), group);
    }

    public Group getGroupByName(String groupName) {
        return groups.get(groupName);
    }

    public void addMemberInExistingGroup(String groupName, User newMember) {
        groups.get(groupName).addMemberToGroup(newMember);
    }
}
