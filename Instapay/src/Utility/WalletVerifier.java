package Utility;

import API.WalletAPI;

import java.util.Map;

public class WalletVerifier implements Verifier {
    public boolean verify(String walletNumber) {
        Map<Object, Object> response = WalletAPI.accountExists(walletNumber);
        return response.get("exists") == "true";
    }
}
