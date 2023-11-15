package Authentication;

import Application.Database;
import User.User;

import java.util.Objects;

public class SessionManager {
    static User currentUser;

    public static User getCurrentUser() {
        return currentUser;
    }

    public static boolean signIn(String username, String password) {
        User user = Database.getUser(username);
        if(user == null || !Objects.equals(user.getPassword(), password))
            return false;
        currentUser = user;
        return true;
    }
}
