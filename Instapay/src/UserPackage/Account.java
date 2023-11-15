package UserPackage;
import java.util.*;
public abstract class Account {
    private ProviderType providerType;
    private ProviderName providerName;
    private Map<Object,Object> accountData;
    public Object getData(Object key) {
        return accountData;
    }
}
