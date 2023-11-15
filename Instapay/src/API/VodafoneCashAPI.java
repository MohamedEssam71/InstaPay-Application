package API;

import java.util.HashMap;
import java.util.Map;

public class VodafoneCashAPI {
    static public Map<Object, Object> inquireBalance(String accountNumber) {
        Map<Object, Object> response = new HashMap<>();
        response.put("balance", (Math.random() * 50000) + 10000);
        return response;
    }
    static public Map<Object, Object> transferToWallet(String sender, String receiver){
        return generateFakeResponse();
    }
    static public Map<Object, Object> payBill(String number, String billNumber){
        return generateFakeResponse();
    }
    static private Map<Object, Object> generateFakeResponse() {
        Map<Object, Object> response = new HashMap<>();
        int status = (int) (Math.random() % 2);
        if(status == 1){
            response.put("status", "success");
        }
        else{
            response.put("status", "failed");
            response.put("message", "Transaction failed, please try again");
        }
        return response;
    }
}
