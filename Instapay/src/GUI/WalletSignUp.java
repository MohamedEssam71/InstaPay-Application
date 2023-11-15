package GUI;

import java.util.Scanner;

public class WalletSignUp implements SignUpStrategy{
    private String walletAddress;
    String phoneNum;
    public void showSignUpScreen(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Wallet Address: ");
        walletAddress = sc.nextLine();
        System.out.println("Enter Phone Number Associated with The Wallet: ");
        phoneNum = sc.nextLine();
    }

}
