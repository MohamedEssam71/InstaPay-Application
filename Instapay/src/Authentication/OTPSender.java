package Authentication;

import API.OTPAPI;

import java.text.DecimalFormat;
import java.util.Objects;
import java.util.Random;

public class OTPSender {
    String otp;

    void sendOTP(String phoneNumber) {
        if (otp == null) {
            return;
        }
        OTPAPI api = new OTPAPI();
        api.sendOTP(phoneNumber, this.otp);
    }

    void generateOTP() {
        otp = new DecimalFormat("000000").format(new Random().nextInt(999999));
    }

    boolean validateOTP(String otp) {
        if (this.otp == null) {
            return false;
        }
        return Objects.equals(otp, this.otp);
    }
}
