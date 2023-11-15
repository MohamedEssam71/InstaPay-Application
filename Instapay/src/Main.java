import Provider.*;
import other.Account;

public class Main {
    public static void main(String[] args) {
        Provider vodafone = new VodafoneCash("vodafone cash");
        Provider fawry = new Fawry("fawry");
        Provider bank = new Bank("bank");
        for (Provider provider : new Provider[]{vodafone, fawry, bank}) {
            System.out.println(provider.inquireBalance(new Account("01000000000")));
        }
    }
}