package controllers;

import exceptions.UserNameAlreadyExistsException;
import models.User;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserController {
    //Controller for CRUD operations on users
    private Map<String, User> users = new HashMap<>();

    public void addUser(User user) {
        if (users.containsKey(user.getUserName())) {
            throw new UserNameAlreadyExistsException();
        }
        users.put(user.getUserName(), user);
    }

    public User getUserByName(String userName) {
        return users.get(userName);
    }
}
