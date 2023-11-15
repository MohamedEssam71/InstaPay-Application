package BillPackage;

public class GasBill extends Bill{
    public GasBill(String billNumber) {
        super(billNumber);
    }
    @Override
    public void display() {
        System.out.println("Gas Bill: " + getBillNumber());
    }
}
