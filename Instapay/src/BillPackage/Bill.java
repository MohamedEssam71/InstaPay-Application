package BillPackage;

import java.util.HashMap;

public abstract class Bill {
    private String billNumber;
    private HashMap<String, String> billContent = new HashMap<>();
    public Bill(String billNumber, HashMap<String,String> billContent) {
        this.billNumber = billNumber;
        this.billContent = billContent;
    }

    public void display(){
        System.out.println("Name: " + billContent.get("Name") + "  Number: " + billContent.get("Number"));
        System.out.println("Provider: " + billContent.get("Provider"));
        System.out.println("Date: " + billContent.get("Date"));
        System.out.println("Previous Reading: " + billContent.get("Previous Reading"));
        System.out.println("Current Reading: " + billContent.get("Current Reading"));
        System.out.println("Total Amount: " + billContent.get("Total Amount"));
        System.out.println("Customer Services: " + billContent.get("Customer Service"));
    }

    public String getBillNumber() {
        return billNumber;
    }

    public HashMap<String, String> getBillContent() {
        return billContent;
    }
}
