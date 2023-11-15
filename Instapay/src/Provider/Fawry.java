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
        FawryAPI fawryAPI = new FawryAPI();
        final Map<Object, Object> response = fawryAPI.inquireBalance(account.getBankNumber());
        return (Double) response.get("balance");
    }

    @java.lang.Override
    public Map<Object, Object> transferToWallet(String senderWalletNumber, String receiverWalletNumber) {
        FawryAPI fawryAPI = new FawryAPI();
        return fawryAPI.transferToWallet(senderWalletNumber, receiverWalletNumber);

    }

    @java.lang.Override
    public Map<Object, Object> payBill(Bill bill) {
        FawryAPI fawryAPI = new FawryAPI();
        return fawryAPI.payBill(bill.getBillNumber());
    }
}
