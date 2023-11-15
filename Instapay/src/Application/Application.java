package Application;

import Authentication.*;
import Bill.*;
import User.*;
import Provider.*;
import Utility.*;

import java.util.Map;


public class Application {
    Authenticator auth = new Authenticator();
    public boolean payBill(String billType, String billNumber) {
        if (billType != "electricity" && billType != "water" && billType != "gas")
            return false;
        Bill bill = BillFactory.create(billType, billNumber);
        return BillPayer.payBill(bill);
    }

    public void sendOTP(String phoneNumber){
        auth.sendOTP(new User(null, null, null, phoneNumber));
    }

    public boolean signUp(String userName, String password, String accountNumber, String phoneNumber, String otp){
        User user = new User(userName, password, accountNumber, phoneNumber);
        return auth.signUp(user, otp);
    }

    public boolean transferToAccount(Double amount, String accountName) {
        User receiver = Database.getUser(accountName);
        if (receiver == null) {
            return false;
        }
        Account receiverAccount = receiver.getAccount();
        if (receiverAccount.getProviderType() == ProviderType.BANK) {
            transferToBank(amount, receiverAccount.getData("number").toString());
        } else {
            transferToWallet(amount, receiverAccount.getData("number").toString());
        }
        return true;
    }

    public boolean transferToWallet(Double amount, String walletNumber) {
        User user = SessionManager.getCurrentUser();
        Provider provider = user.getProvider();
        Double balance = provider.inquireBalance(user.getAccount());
        if (balance < amount) {
            return false;
        }
        Verifier verifier = new WalletVerifier();
        if (!verifier.verify(walletNumber)) {
            return false;
        }
        Map<Object, Object> response = provider.transferToWallet(user.getAccount(), walletNumber);
        return response.get("status") == "success";
    }

    public boolean transferToBank(Double amount, String bankNumber) {
        User user = SessionManager.getCurrentUser();

        if (user.getAccount().getProviderType() != ProviderType.BANK) {
            return false;
        }

        Bank provider = (Bank) user.getProvider();
        Double balance = provider.inquireBalance(user.getAccount());
        if (balance < amount) {
            return false;
        }
        Verifier verifier = new BankVerifier();
        if (!verifier.verify(bankNumber)) {
            return false;
        }
        Map<Object, Object> response = provider.transferToBank(user.getAccount(), bankNumber);
        return response.get("status") == "success";
    }

    public Double inquireBalance() {
        User user = SessionManager.getCurrentUser();
        Provider provider = user.getProvider();
        return provider.inquireBalance(user.getAccount());
    }
}
