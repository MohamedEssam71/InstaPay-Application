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
        final Map<Object, Object> response = vodafoneCashAPI.inquireBalance(account.getBankNumber());
        return (Double) response.get("balance");
    }

    @java.lang.Override
    public Map<Object, Object> transferToWallet(String senderWalletNumber, String receiverWalletNumber) {
        VodafoneCashAPI vodafoneCashAPI = new VodafoneCashAPI();
        return vodafoneCashAPI.transferToWallet(senderWalletNumber, receiverWalletNumber);

    }

    @java.lang.Override
    public Map<Object, Object> payBill(Bill bill) {
        VodafoneCashAPI vodafoneCashAPI = new VodafoneCashAPI();
        return vodafoneCashAPI.payBill(bill.getBillNumber());
    }
}
