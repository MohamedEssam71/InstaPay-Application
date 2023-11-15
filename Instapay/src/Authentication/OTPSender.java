package Authentication;

import java.text.DecimalFormat;
import java.util.Objects;
import java.util.Random;

public class OTPSender {
    String otp;

    void sendOTP(String phoneNumber) {
        System.out.println("Hello" + phoneNumber + ".");
        System.out.println("Your Instapay signup OTP is: " + otp);
    }

    void generateOTP() {
        otp = new DecimalFormat("000000").format(new Random().nextInt(999999));
    }

    boolean validateOTP(String otp) {
        return Objects.equals(otp, this.otp);
    }
}
