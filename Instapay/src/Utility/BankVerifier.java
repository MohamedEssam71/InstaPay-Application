package Utility;
import API.BankAPI;
import API.WalletAPI;

import java.util.Map;

public class BankVerifier implements Verifier{
    public boolean verify(String accountNumber) {
        Map<Object, Object> response = BankAPI.accountExists(accountNumber);
        return response.get("exists") == "true";
    }
}
