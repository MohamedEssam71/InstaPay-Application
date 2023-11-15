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
        final Map<Object, Object> response = bankAPI.inquireBalance(account.getBankNumber());
        return (Double) response.get("balance");
    }

    @java.lang.Override
    public Map<Object, Object> transferToWallet(String senderBankNumber, String receiverBankNumber) {
        BankAPI bankAPI = new BankAPI();
        return bankAPI.transferToWallet(senderBankNumber, receiverBankNumber);
    }

    public Map<Object, Object> transferToBank(String senderBankNumber, String receiverBankNumber){
        BankAPI bankAPI = new BankAPI();
        return bankAPI.transferToBank(senderBankNumber, receiverBankNumber);
    }

    @java.lang.Override
    public Map<Object, Object> payBill(Bill bill) {
        BankAPI bankAPI = new BankAPI();
        return bankAPI.payBill(bill.getBillNumber());
    }
}