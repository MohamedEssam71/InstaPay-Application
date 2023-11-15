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

    abstract public Map<Object, Object> transferToWallet(Account senderAccount, String receiverNumber);

    public Map<Object, Object> transferToAccount(Account senderAccount, String receiverAccount){
        return null;
    }


    abstract public Map<Object, Object> payBill(Account account, Bill bill);
}