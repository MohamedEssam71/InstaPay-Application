package Utility;

import java.util.regex.Pattern;

public class PhoneNumberValidator implements Validator{

    @Override
    public boolean validate(String phoneNumber) {
        return Pattern.matches("01[0|1|2|5]\\d{8}", phoneNumber);
    }
}
