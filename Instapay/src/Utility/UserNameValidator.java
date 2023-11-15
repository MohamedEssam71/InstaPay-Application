package Utility;

import Application.Database;

public class UserNameValidator implements Validator {
    public boolean validate(String s) {
        if (Database.getUser(s) != null || s.length() < 5) {
            return false;
        }
        return true;
    }
}
