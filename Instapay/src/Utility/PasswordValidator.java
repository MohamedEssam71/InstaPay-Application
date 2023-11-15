package Utility;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PasswordValidator implements Validator {
    public boolean validate(String s) {
        Pattern pattern = Pattern.compile("^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[-!@#$%^&*_=+/.?<>]).{8,20}$");
        Matcher matcher = pattern.matcher(s);
        return matcher.matches();
    }
}
