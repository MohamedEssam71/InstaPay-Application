package BillPackage;

public class WaterBill extends Bill{
    public WaterBill(String billNumber) {
        super(billNumber);
    }
    @Override
    public void display() {
        System.out.println("Water Bill: " + getBillNumber());
    }
}
