package Provider;

import java.util.Objects;

class ProviderFactory {
    public Provider createProvider(String type, String providerName) {
        if (Objects.equals(type, "bank")) {
            return new Bank(providerName);
        } else if (Objects.equals(type, "wallet")) {
            if (Objects.equals(providerName, "vodafone cash")) {
                return new VodafoneCash(providerName);
            } else if (Objects.equals(providerName, "fawry")) {
                return new Fawry(providerName);
            } else {
                return null;
            }
        } else {
            return null;
        }
    }
}