package Bill;

import Authentication.SessionManager;

import java.util.Map;

import User.*;
import Provider.*;

public class BillPayer {
    public static boolean payBill(Bill bill) {
        User user = SessionManager.getCurrentUser();
        Provider provider = user.getProvider();
        Map<Object, Object> response = provider.payBill(user.getAccount(), bill);
        return response.get("status") == "success";
    }
}
