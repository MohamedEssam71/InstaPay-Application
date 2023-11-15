import Provider.*;
import other.Account;

public class Main {
    public static void main(String[] args) {
        Provider vodafone = new VodafoneCash();
        Provider fawry = new Fawry();
        Provider bank = new Bank();
        for (Provider provider : new Provider[]{vodafone, fawry, bank}) {
            System.out.println(provider.inquireBalance(new Account("01000000000")));
        }
    }
}