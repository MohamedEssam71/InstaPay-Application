package User;

import Provider.*;

public class User {
    private String name;
    private String password;
    private String mobileNumber;
    private Account account;

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
}