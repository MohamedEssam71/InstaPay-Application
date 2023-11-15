package Authentication;

import Application.Database;
import Utility.PasswordValidator;
import Utility.UserNameValidator;
import Utility.Validator;
import User.User;

public class Authenticator {
    OTPSender otpSender = new OTPSender();

    public boolean verifyUser(User user) {
        boolean valid;
        Validator validator = new UserNameValidator();
        valid = validator.validate(user.getName());

        validator = new PasswordValidator();
        valid &= validator.validate(user.getPassword());



        return valid;
    }

    public void sendOTP(User user) {
        otpSender.generateOTP();
        otpSender.sendOTP(user.getMobileNumber());
    }

    public boolean signUp(User user, String otp) {
        if(!otpSender.validateOTP(otp)){
            return false;
        }
        Database.addUser(user);
        return true;
    }
}
