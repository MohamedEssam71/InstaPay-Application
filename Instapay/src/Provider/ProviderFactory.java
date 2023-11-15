package Provider;

import User.ProviderName;
import User.ProviderType;

import java.util.Objects;

public class ProviderFactory {
    public static Provider createProvider(ProviderType type, ProviderName providerName) {
        if (type == ProviderType.BANK) {
            return new Bank();
        } else if (type == ProviderType.WALLET) {
            if (providerName == ProviderName.VODAFONECASH) {
                return new VodafoneCash();
            } else if (providerName == ProviderName.FAWRY) {
                return new Fawry();
            } else {
                return null;
            }
        } else {
            return null;
        }
    }
}