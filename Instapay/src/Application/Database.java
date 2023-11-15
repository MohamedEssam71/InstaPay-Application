package Application;

import other.User;

import java.util.Map;

public class Database {
    static Map<String, User> users;

    public static void addUser(User user) {
        if (users.containsKey(user.getName()))
            return;
        users.put(user.getName(), user);
    }

    public static User getUser(String username) {
        if (!users.containsKey(username)) {
            return null;
        }
        return users.get(username);
    }
}
