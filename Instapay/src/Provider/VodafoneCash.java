package Provider;

import java.util.Map;

import API.VodafoneCashAPI;
import other.*;

public class VodafoneCash extends WalletProvider{
    public VodafoneCash(String name){
        super(name);
    }

    public Double inquireBalance(Account account) {
        VodafoneCashAPI vodafoneCashAPI = new VodafoneCashAPI();
        final Map<Object, Object> response = vodafoneCashAPI.inquireBalance(account.getProviderNumber());
        return (Double) response.get("balance");
    }

    @java.lang.Override
    public Map<Object, Object> transferToWallet(Account senderAccount, String receiverNumber) {
        VodafoneCashAPI vodafoneCashAPI = new VodafoneCashAPI();
        return vodafoneCashAPI.transferToWallet(senderAccount.getProviderNumber(), receiverNumber);

    }

    @java.lang.Override
    public Map<Object, Object> payBill(Account account, Bill bill) {
        VodafoneCashAPI vodafoneCashAPI = new VodafoneCashAPI();
        return vodafoneCashAPI.payBill(account.getProviderNumber(), bill.getBillNumber());
    }
}
