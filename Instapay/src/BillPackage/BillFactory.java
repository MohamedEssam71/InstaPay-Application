package BillPackage;
import java.time.LocalDate;
import java.util.*;

public class BillFactory {

    private HashMap<String, String> billContent = new HashMap<>();

    public Bill create(String billType, String billNumber){
        Bill bill;
        fetchBill(billType);
        switch (billType){
            case "Electricity" -> bill = new ElectricityBill(billNumber,billContent);
            case "Water" -> bill = new WaterBill(billNumber,billContent);
            case "Gas" -> bill = new GasBill(billNumber,billContent);
            default -> throw new IllegalStateException("Unexpected value: " + billType);
        }
        return bill;
    }
    public void fetchBill(String billType){
        String name, number, provider, date;
        String previousReading, currentReading;
        String totalAmount, customerService;

        Random random = new Random();
        date = randomDate();
        previousReading = String.valueOf(Math.abs(random.nextInt()%1000));
        currentReading = String.valueOf(Math.abs(random.nextInt()%1000));
        totalAmount = String.valueOf(Math.abs(random.nextInt()%1000)) + " L.E";
        customerService = String.valueOf(Math.abs(random.nextInt()%10000000));
        switch (billType){
            case "Electricity":
                name = "Electricity";
                number = "111";
                provider = "Cairo Electricity Production Company";
                previousReading += " KW/Hr";
                currentReading += " KW/Hr";
                break;
            case "Water":
                name = "Water";
                number = "222";
                provider = "Cairo Water Production Company";
                previousReading += " cu ft";
                currentReading += " cu ft";
                break;
            case "Gas":
                name = "Gas";
                number = "333";
                provider = "Cairo Gas Production Company";
                previousReading += " cm3";
                currentReading += " cm3";
                break;
            default:
                name = provider = number = currentReading = previousReading = "";
        }
        billContent.put("Name", name);
        billContent.put("Number", number);
        billContent.put("Provider", provider);
        billContent.put("Date", date);
        billContent.put("Previous Reading", previousReading);
        billContent.put("Current Reading", currentReading);
        billContent.put("Total Amount", totalAmount);
        billContent.put("Customer Service", customerService);

    }
    private String randomDate(){
        Random random = new Random();

        // Define a start and end date range
        LocalDate startDate = LocalDate.of(2000, 1, 1);
        LocalDate endDate = LocalDate.of(2023, 1, 1);

        // Calculate the number of days between the start and end date
        long startDay = startDate.toEpochDay();
        long endDay = endDate.toEpochDay();
        long randomDay = startDay + random.nextInt((int) (endDay - startDay));

        // Convert the random day back to a LocalDate
        return String.valueOf(LocalDate.ofEpochDay(randomDay));
    }
    /*
    Electricity Bill:
        The name and address of the electricity provider and the customer
        The bill date and number
        The meter number and the billing period
        The previous and current meter readings and the consumption in kilowatt-hours (kWh)
        The tariff and the total amount charged for the electricity usage
        The total amount due and the payment methods

     Gas Bill:

     */
}
