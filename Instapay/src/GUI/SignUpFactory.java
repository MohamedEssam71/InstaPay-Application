package GUI;

import java.util.Objects;

public class SignUpFactory {
    private SignUpStrategy signUpType = null;
    public SignUpStrategy createSignUpMethod(String type){
        if(Objects.equals(type, "Bank")){
            signUpType = new BankSignUp();
        } else if (Objects.equals(type, "Wallet")){
            signUpType = new WalletSignUp();
        }
        return signUpType;
    }
}
