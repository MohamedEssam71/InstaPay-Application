package BillPackage;

public class ElectricityBill extends Bill{
    public ElectricityBill(String billNumber) {
        super(billNumber);
    }

    @Override
    public void display() {
        System.out.println("Electricity Bill: " + getBillNumber());
    }
}
