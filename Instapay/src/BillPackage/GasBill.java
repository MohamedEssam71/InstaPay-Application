package BillPackage;

import java.util.HashMap;

public class GasBill extends Bill{
    public GasBill(String billNumber, HashMap<String,String> billContent) {
        super(billNumber,billContent);
    }
//    @Override
//    public void display() {
//        System.out.println("Gas Bill: " + getBillNumber());
//        for (HashMap.Entry<String,String> entry : getBillContent().entrySet())
//            System.out.println("Key = " + entry.getKey() +
//                    ", Value = " + entry.getValue());
//    }
}
