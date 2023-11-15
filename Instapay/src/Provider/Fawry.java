package Provider;

import java.util.Map;

import API.FawryAPI;
import API.VodafoneCashAPI;
import Bill.Bill;
import User.Account;


public class Fawry extends WalletProvider{

    @java.lang.Override
    public Double inquireBalance(Account account) {
        final Map<Object, Object> response = FawryAPI.inquireBalance(account.getData("number").toString());
        return (Double) response.get("balance");
    }

    @java.lang.Override
    public Map<Object, Object> transferToWallet(Account senderAccount, String receiverWalletNumber) {
        return FawryAPI.transferToWallet(senderAccount.getData("number").toString(), receiverWalletNumber);

    }

    @java.lang.Override
    public Map<Object, Object> payBill(Account account, Bill bill) {
        return FawryAPI.payBill(account.getData("number").toString(), bill.getBillNumber());
    }

    @java.lang.Override
    public boolean accountExists(Account account) {
        Map<Object, Object> response = FawryAPI.accountExists(account.getData("number").toString());
        return response.get("exists") == "true";
    }
}
