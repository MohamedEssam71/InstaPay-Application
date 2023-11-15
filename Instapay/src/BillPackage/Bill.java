package BillPackage;

import java.time.LocalDate;
import java.util.HashMap;

public class Bill {
    private String billNumber;
    private HashMap<Object, Object> billContent;
    public Bill(String billNumber, HashMap<Object,Object> billContent) {
        this.billNumber = billNumber;
        this.billContent = billContent;

    }

//    public void display(){
//        System.out.println("Name: " + billContent.get("Name") + "  Number: " + billContent.get("Number"));
//        System.out.println("Provider: " + billContent.get("Provider"));
//        System.out.println("Date: " + billContent.get("Date"));
//        System.out.println("Previous Reading: " + billContent.get("Previous Reading"));
//        System.out.println("Current Reading: " + billContent.get("Current Reading"));
//        System.out.println("Total Amount: " + billContent.get("Total Amount"));
//        System.out.println("Customer Services: " + billContent.get("Customer Service"));
//    }

    public String getBillNumber() {
        return billNumber;
    }

    public HashMap<Object, Object> getBillContent() {
        return billContent;
    }

    public Object getData(Object key){
        return billContent.get(key);
    }
}
