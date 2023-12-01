package API;

public class OTPAPI {
    static public String sendOTP(String phoneNumber, String otp) {
        String message = "Hello " + phoneNumber + ".\n";
        message += "Your Instapay signup OTP is: " + otp + "\n";
        return message;
    }
}
