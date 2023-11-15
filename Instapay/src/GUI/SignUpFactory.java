package GUI;

import java.util.Objects;

public class SignUpFactory {
    public static SignUpStrategy createSignUpMethod(String type){
        SignUpStrategy signUpType = null;
        if(Objects.equals(type, "Bank")){
            signUpType = new BankSignUp();
        } else if (Objects.equals(type, "Wallet")){
            signUpType = new WalletSignUp();
        }
        return signUpType;
    }
}
