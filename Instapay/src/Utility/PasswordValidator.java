package Utility;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PasswordValidator implements Validator {
    public boolean validate(String s) {
        Pattern pattern = Pattern.compile("^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)(?=.*[!@#$%^&*()_+{}\\[\\]:;<>,.?~\\\\-])[A-Za-z\\d!@#$%^&*()_+{}\\[\\]:;<>,.?~\\\\-]{8,}$\n");
        Matcher matcher = pattern.matcher(s);
        return matcher.matches();
    }
}
