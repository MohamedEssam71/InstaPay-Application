package Provider;
import java.util.Map;

import API.BankAPI;
import API.VodafoneCashAPI;
import Bill.Bill;
import User.Account;

public class Bank extends Provider{

    @java.lang.Override
    public Double inquireBalance(Account account) {
        Map<Object, Object> response = BankAPI.inquireBalance(account.getData("number").toString());
        return (Double) response.get("balance");
    }

    @java.lang.Override
    public Map<Object, Object> transferToWallet(Account senderAccount, String receiverNumber) {
        return BankAPI.transferToWallet(senderAccount.getData("number").toString(), receiverNumber);
    }

    public Map<Object, Object> transferToBank(Account senderAccount, String receiverNumber){
        return BankAPI.transferToBank(senderAccount.getData("number").toString(), receiverNumber);
    }

    @java.lang.Override
    public Map<Object, Object> payBill(Account account, Bill bill) {
        return BankAPI.payBill(account.getData("number").toString(), bill.getBillNumber());
    }

    @java.lang.Override
    public Map<Object, Object> accountExists(Account account) {
        return VodafoneCashAPI.accountExists(account.getData("number").toString());
    }
}