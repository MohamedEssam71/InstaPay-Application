package Provider;

import java.util.Map;

import API.VodafoneCashAPI;
import Bill.Bill;
import User.Account;

public class VodafoneCash extends WalletProvider {
    public Double inquireBalance(Account account) {
        final Map<Object, Object> response = VodafoneCashAPI.inquireBalance(account.getData("number").toString());
        return (Double) response.get("balance");
    }

    @java.lang.Override
    public Map<Object, Object> transferToWallet(Account senderAccount, String receiverNumber) {
        return VodafoneCashAPI.transferToWallet(senderAccount.getData("number").toString(), receiverNumber);

    }

    @java.lang.Override
    public Map<Object, Object> payBill(Account account, Bill bill) {
        return VodafoneCashAPI.payBill(account.getData("number").toString(), bill.getBillNumber());
    }

    @java.lang.Override
    public boolean accountExists(Account account) {
        Map<Object, Object> response = VodafoneCashAPI.accountExists(account.getData("number").toString());
        return response.get("exists") == "true";
    }
}
