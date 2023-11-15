package API;

import java.util.HashMap;
import java.util.Map;

public class WalletAPI {
    static public Map<Object, Object> accountExists(String number) {
        Map<Object, Object> response = generateFakeResponse();
        response.put("number", number);
        if (response.get("status") == "success") {
            response.put("exists", true);
        } else {
            response.put("exists", false);
        }
        return response;
    }

    static private Map<Object, Object> generateFakeResponse() {
        Map<Object, Object> response = new HashMap<>();
        int status = (int) (Math.random() % 2);
        if (status == 1) {
            response.put("status", "success");
        } else {
            response.put("status", "failed");
            response.put("message", "Transaction failed, please try again");
        }
        return response;
    }
}
