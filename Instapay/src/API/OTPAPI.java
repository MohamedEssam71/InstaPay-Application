package API;

public class OTPAPI {
    static public void sendOTP(String phoneNumber, String otp) {
        System.out.println("Hello" + phoneNumber + ".");
        System.out.println("Your Instapay signup OTP is: " + otp);
    }
}
