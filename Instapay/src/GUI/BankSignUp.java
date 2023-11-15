package GUI;
import Utility.*;

import java.util.Scanner;

public class BankSignUp implements SignUpStrategy{
    private String bankNum;
    private String phoneNum;
    public void showSignUpScreen(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Bank Number: ");
        bankNum = sc.nextLine();
        System.out.print("Enter Phone Number Associated with Bank Account: ");
        phoneNum = sc.nextLine();
    }
    public String getBankNum() {
        return bankNum;
    }

    public String getPhoneNum() {
        return phoneNum;
    }
}
