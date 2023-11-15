package User;

import Provider.*;

import java.util.HashMap;
import java.util.Map;

public class User {
    private String name;
    private String password;
    private String mobileNumber;
    private Account account;

    public User(String userName, String password, String accountNumber, String phoneNumber) {
        name = userName;
        this.password = password;
        mobileNumber = phoneNumber;
        Map<Object, Object> map = new HashMap<>();
        map.put("number", accountNumber);
        account = new Account(ProviderType.WALLET, ProviderName.FAWRY, map);
    }

    public Provider getProvider() {
        return ProviderFactory.createProvider(account.getProviderType(), account.getProviderName());
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public Account getAccount() {
        return account;
    }
}