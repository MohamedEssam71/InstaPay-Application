package Authentication;

import Application.Database;
import Utility.*;
import User.*;

public class Authenticator {
    OTPSender otpSender = new OTPSender();

    public boolean validateUserInfo(User user) {
        boolean valid;
        Validator validator = new UserNameValidator();
        valid = validator.validate(user.getName());

        validator = new PasswordValidator();
        valid &= validator.validate(user.getPassword());

        return valid;
    }

    public boolean verifyUserInfo(User user) {
        Verifier verifier;
        if (user.getAccount().getProviderType() == ProviderType.BANK) {
            verifier = new BankVerifier();
        } else {
            verifier = new WalletVerifier();
        }
        return verifier.verify(user.getAccount().getData("number").toString());
    }

    public String sendOTP(User user) {
        otpSender.generateOTP();
       return otpSender.sendOTP(user.getMobileNumber());
    }

    public boolean signUp(User user, String otp) {
        if (!validateUserInfo(user) || !verifyUserInfo(user) || !otpSender.validateOTP(otp)) {
            return false;
        }
        return Database.addUser(user);
    }
}
