package BillPackage;

import java.util.HashMap;

public class WaterBill extends Bill{
    public WaterBill(String billNumber, HashMap<String,String> billContent) {
        super(billNumber,billContent);
    }
//    @Override
//    public void display() {
//        System.out.println("Water Bill: " + getBillNumber());
//        for (HashMap.Entry<String,String> entry : getBillContent().entrySet())
//            System.out.println("Key = " + entry.getKey() +
//                    ", Value = " + entry.getValue());
//    }
}
