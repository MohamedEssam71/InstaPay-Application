package GUI;

import java.util.Scanner;

public class WalletSignUp implements SignUpStrategy{
    private String walletNumber;
    String phoneNum;
    public void showSignUpScreen(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Wallet Address: ");
        walletNumber = sc.nextLine();
        System.out.print("Enter Phone Number Associated with The Wallet: ");
        phoneNum = sc.nextLine();
    }

    public String getProviderNum() {
        return walletNumber;
    }

    public String getPhoneNum() {
        return phoneNum;
    }
}
