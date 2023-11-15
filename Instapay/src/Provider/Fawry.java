package Provider;

import java.util.Map;

import API.BankAPI;
import API.FawryAPI;
import other.*;


public class Fawry extends WalletProvider{
    public Fawry(String name){
        super(name);
    }

    @java.lang.Override
    public Double inquireBalance(Account account) {
        final Map<Object, Object> response = FawryAPI.inquireBalance(account.getProviderNumber());
        return (Double) response.get("balance");
    }

    @java.lang.Override
    public Map<Object, Object> transferToWallet(Account senderAccount, String receiverWalletNumber) {
        return FawryAPI.transferToWallet(senderAccount.getProviderNumber(), receiverWalletNumber);

    }

    @java.lang.Override
    public Map<Object, Object> payBill(Account account, Bill bill) {
        return FawryAPI.payBill(account.getProviderNumber(), bill.getBillNumber());
    }
}
