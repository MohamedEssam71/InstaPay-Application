import BillPackage.Bill;
import BillPackage.BillFactory;

public class Main {
    public static void main(String[] args) {
        BillFactory billFactory = new BillFactory();
        Bill bill = billFactory.create("Gas","111");
        bill.display();
    }
}