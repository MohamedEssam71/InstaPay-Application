package API;

import java.util.HashMap;
import java.util.Map;

public class WalletAPI {
    static public Map<Object, Object> accountExists(String number) {
        Map<Object, Object> response = generateFakeResponse();
        response.put("number", number);
        response.put("exists", "true");
        return response;
    }

    static private Map<Object, Object> generateFakeResponse() {
        Map<Object, Object> response = new HashMap<>();
        response.put("status", "success");
        return response;
    }
}
