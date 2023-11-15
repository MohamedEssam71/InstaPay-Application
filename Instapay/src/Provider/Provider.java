package Provider;

import Bill.Bill;
import User.Account;

import java.util.Map;

abstract public class Provider {

    abstract public Double inquireBalance(Account account);

    abstract public Map<Object, Object> transferToWallet(Account senderAccount, String receiverNumber);

    public Map<Object, Object> transferToAccount(Account senderAccount, String receiverAccount){
        return null;
    }

    abstract public Map<Object, Object> payBill(Account account, Bill bill);

    abstract public boolean accountExists(Account account);
}