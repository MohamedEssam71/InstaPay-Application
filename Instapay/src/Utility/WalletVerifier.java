package Utility;

import Provider.ProviderFactory;
import Provider.Provider;
import other.Account;

public class WalletVerifier {
    public boolean verify(Account account) {
        Provider provider = ProviderFactory.createProvider(account.providerType, account.providerName);


    }
}
