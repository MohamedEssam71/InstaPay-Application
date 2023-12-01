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

    public static boolean addUser(User user) {
        if (users.containsKey(user.getName()))
            return false;
        users.put(user.getName(), user);
        return true;
    }

    public static User getUser(String username) {
        if (!users.containsKey(username)) {
            return null;
        }
        return users.get(username);
    }
}
