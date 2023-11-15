package Provider;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import other.*;
import API.*;

public class Bank extends Provider{
    public Bank(String name){
        super(name);
    }

    @java.lang.Override
    public Double inquireBalance(Account account) {
        BankAPI bankAPI = new BankAPI();
        final Map<Object, Object> response = bankAPI.inquireBalance(account.getProviderNumber());
        return (Double) response.get("balance");
    }

    @java.lang.Override
    public Map<Object, Object> transferToWallet(Account senderAccount, String receiverNumber) {
        BankAPI bankAPI = new BankAPI();
        return bankAPI.transferToWallet(senderAccount.getProviderNumber(), receiverNumber);
    }

    public Map<Object, Object> transferToBank(Account senderAccount, String receiverNumber){
        BankAPI bankAPI = new BankAPI();
        return bankAPI.transferToBank(senderAccount.getProviderNumber(), receiverNumber);
    }

    @java.lang.Override
    public Map<Object, Object> payBill(Account account, Bill bill) {
        BankAPI bankAPI = new BankAPI();
        return bankAPI.payBill(account.getProviderNumber(), bill.getBillNumber());
    }
}