package Provider;

import java.util.Map;

import API.VodafoneCashAPI;
import other.*;

public class VodafoneCash extends WalletProvider{
    public Double inquireBalance(Account account) {
        final Map<Object, Object> response = VodafoneCashAPI.inquireBalance(account.getProviderNumber());
        return (Double) response.get("balance");
    }

    @java.lang.Override
    public Map<Object, Object> transferToWallet(Account senderAccount, String receiverNumber) {
        return VodafoneCashAPI.transferToWallet(senderAccount.getProviderNumber(), receiverNumber);

    }

    @java.lang.Override
    public Map<Object, Object> payBill(Account account, Bill bill) {
        return VodafoneCashAPI.payBill(account.getProviderNumber(), bill.getBillNumber());
    }
}
