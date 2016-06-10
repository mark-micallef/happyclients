package com.mea.happyclients.users;

import com.mea.happyclients.clients.Client;

import java.util.HashMap;

/**
 * Maintains a database of users
 */
public class UserDB {

    protected HashMap<String, User> users;

    public UserDB() {
        users = new HashMap<>();
    }

    public void addClient(User user) {
        users.put(user.getId(), user);
    }

    public User getUserByID(String id) {
        return users.get(id);
    }

}
