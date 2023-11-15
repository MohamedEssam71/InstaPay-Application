package API;

import java.util.HashMap;
import java.util.Map;

public class BankAPI {
    static public Map<Object, Object> inquireBalance(String accountNumber) {
        Map<Object, Object> response = new HashMap<>();
        response.put("balance", (Math.random() * 50000) + 10000);
        return response;
    }
    static public Map<Object, Object> transferToBank(String sender, String receiver) {
        return generateFakeResponse();
    }
    static public Map<Object, Object> transferToWallet(String sender, String receiver) {
        return generateFakeResponse();

    }

    static public Map<Object, Object> accountExists(String number) {
        Map<Object, Object> response = generateFakeResponse();
        response.put("number", number);
        int status = (int) (Math.random() % 2);
        if (response.get("status") == "success") {
            response.put("exists", true);
        } else {
            response.put("exists", false);
        }
        return response;
    }
    static public Map<Object, Object> payBill(String number, String billNumber) {
        return generateFakeResponse();
    }
    static private Map<Object, Object> generateFakeResponse() {
        Map<Object, Object> response = new HashMap<>();
        int status = (int) (Math.random() % 2);
        if (status == 1) {
            response.put("status", "success");
            response.put("transactionCode", String.valueOf(Math.random() % 20000));
        } else {
            response.put("status", "failed");
            response.put("message", "Transaction failed, please try again");
        }
        return response;
    }

}
