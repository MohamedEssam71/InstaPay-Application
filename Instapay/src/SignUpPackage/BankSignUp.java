package SignUpPackage;
import java.util.Scanner;

public class BankSignUp implements SignUpStrategy{
    private String bankNum;
    private String phoneNum;
    public void showSignUpScreen(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Bank Number: ");
        bankNum = sc.nextLine();
        System.out.println("Enter Phone Number Associated with Bank Account: ");
        phoneNum = sc.nextLine();
    }
}
