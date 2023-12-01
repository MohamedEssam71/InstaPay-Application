package Bill;

import java.util.HashMap;

public class Bill {
    private String billNumber;
    private HashMap<Object, Object> billContent;
    public Bill(String billNumber, HashMap<Object,Object> billContent) {
        this.billNumber = billNumber;
        this.billContent = billContent;

    }

    public String display(){
        String form = "Name: " + billContent.get("Name") + "  Number: " + billContent.get("Number") +
                "\n" + "Provider: " + billContent.get("Provider") + "\n" +
                "Date: " + billContent.get("Date") + "\n" + "Previous Reading: "
                + billContent.get("Previous Reading") + "\n" + "Current Reading: " +
                billContent.get("Current Reading") + "\n" + "Total Amount: " + billContent.get("Total Amount")
                + "\n" + "Customer Services: " + billContent.get("Customer Service") + "\n";
        return form;
    }

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
