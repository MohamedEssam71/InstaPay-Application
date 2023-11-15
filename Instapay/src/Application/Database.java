package Application;

import User.User;

import javax.xml.crypto.Data;
import java.util.HashMap;
import java.util.Map;

public class Database {
    static Map<String, User> users;

    public Database(){
        users = new HashMap<String, User>();
    }

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
