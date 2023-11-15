package API;

import java.util.HashMap;
import java.util.Map;

public class BankAPI {
    public Map<Object, Object> inquireBalance(String accountNumber) {
        Map<Object, Object> response = new HashMap<>();
        response.put("balance", Math.random() % 30000);
        return response;
    }

    public Map<Object, Object> transferToBank(String sender, String receiver){
        return generateFakeResponse();
    }
    public Map<Object, Object> transferToWallet(String sender, String receiver){
        return generateFakeResponse();
    }
    public Map<Object, Object> payBill(String number, String billNumber){
        return generateFakeResponse();
    }

    private Map<Object, Object> generateFakeResponse() {
        Map<Object, Object> response = new HashMap<>();
        int status = (int) (Math.random() % 2);
        if(status == 1){
            response.put("status", "success");
            response.put("transactionCode", String.valueOf(Math.random() % 20000));
        }
        else{
            response.put("status", "failed");
            response.put("message", "Transaction failed, please try again");
        }
        return response;
    }

}
