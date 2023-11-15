package Provider;

import other.Account;
import other.Bill;

import java.util.Map;

abstract public class Provider {
    String name;

    public Provider(String name){
        this.name = name;
    }

    abstract public Double inquireBalance(Account account);

    abstract public Map<Object, Object> transferToWallet(String senderWalletNumber, String receiverWalletNumber);


    abstract public Map<Object, Object> payBill(Bill bill);
}