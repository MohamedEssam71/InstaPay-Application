package Authentication;

import Application.Database;
import User.User;

import java.util.Objects;

public class SessionManager {
    User currentUser;

    public User getCurrentUser() {
        return currentUser;
    }

    public boolean signIn(String username, String password) {
        User user = Database.getUser(username);
        if(user == null || !Objects.equals(user.getPassword(), password))
            return false;
        return true;
    }
}
