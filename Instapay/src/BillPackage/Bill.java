package BillPackage;

public abstract class Bill {
    private String billNumber;

    public Bill(String billNumber) {
        this.billNumber = billNumber;
    }

    public abstract void display();

    public String getBillNumber() {
        return billNumber;
    }
}
