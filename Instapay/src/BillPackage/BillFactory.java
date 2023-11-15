package BillPackage;

import java.util.ArrayList;
import java.util.HashMap;

public class BillFactory {

    private HashMap<String, ArrayList<String>> bills;

    public Bill create(String billType, String billNumber){
        Bill bill;

        switch (billType){
            case "Electricity" -> bill = new ElectricityBill(billNumber);
            case "Water" -> bill = new WaterBill(billNumber);
            case "Gas" -> bill = new GasBill(billNumber);
            default -> throw new IllegalStateException("Unexpected value: " + billType);
        }

        return bill;
    }
    public void fetchBill(){

    }
}
