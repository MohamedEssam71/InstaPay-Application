package User;

import java.util.*;

public abstract class Account {
    private ProviderType providerType;
    private ProviderName providerName;
    private Map<Object, Object> accountData;

    protected Account(ProviderType providerType, ProviderName providerName, Map<Object, Object> accountData) {
        this.providerType = providerType;
        this.providerName = providerName;
        this.accountData = accountData;
    }

    public Object getData(Object key) {
        return accountData.get(key);
    }

    public ProviderType getProviderType() {
        return providerType;
    }

    public ProviderName getProviderName() {
        return providerName;
    }
}
