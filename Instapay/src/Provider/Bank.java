package Provider;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.function.BiFunction;

import other.*;
import API.*;

public class Bank extends Provider{

    @java.lang.Override
    public Double inquireBalance(Account account) {
        Map<Object, Object> response = BankAPI.inquireBalance(account.getProviderNumber());
        return (Double) response.get("balance");
    }

    @java.lang.Override
    public Map<Object, Object> transferToWallet(Account senderAccount, String receiverNumber) {
        return BankAPI.transferToWallet(senderAccount.getProviderNumber(), receiverNumber);
    }

    public Map<Object, Object> transferToBank(Account senderAccount, String receiverNumber){
        return BankAPI.transferToBank(senderAccount.getProviderNumber(), receiverNumber);
    }

    @java.lang.Override
    public Map<Object, Object> payBill(Account account, Bill bill) {
        return BankAPI.payBill(account.getProviderNumber(), bill.getBillNumber());
    }
}