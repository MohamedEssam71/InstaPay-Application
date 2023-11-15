package Utility;

import API.WalletAPI

import java.util.Map;

public class WalletVerifier implements Verifier {
    public boolean verify(String number) {
        Map<Object, Object> response = WalletAPI.accountExists(number);
        if(response == null) {
            return false;
        }
        return response.get("exists") == "true";
    }
}
