package BillPackage;
import java.time.LocalDate;
import java.util.*;

public class BillFactory {


    public Bill create(String billType, String billNumber){
        return new Bill(billNumber,fetchBill(billType, billNumber));
    }

    public HashMap<Object,Object> fetchBill(String billType, String billNumber){
        HashMap<Object, Object> billContent = new HashMap<>();

        String name, number, provider, date;
        String previousReading, currentReading;
        String totalAmount, customerService;

        Random random = new Random();
        date = randomDate();
        previousReading = String.valueOf(Math.abs(random.nextInt()%1000));
        currentReading = String.valueOf(Math.abs(random.nextInt()%1000));
        totalAmount = Math.abs(random.nextInt() % 1000) + " L.E";
        customerService = String.valueOf(Math.abs(random.nextInt()%10000000));
        number = billNumber;

        switch (billType) {
            case "Electricity" -> {
                name = "Electricity";
                provider = "Cairo Electricity Production Company";
                previousReading += " KW/Hr";
                currentReading += " KW/Hr";
            }
            case "Water" -> {
                name = "Water";
                provider = "Cairo Water Production Company";
                previousReading += " cu ft";
                currentReading += " cu ft";
            }
            case "Gas" -> {
                name = "Gas";
                provider = "Cairo Gas Production Company";
                previousReading += " cm3";
                currentReading += " cm3";
            }
            default -> name = provider = number = currentReading = previousReading = "";
        }
        billContent.put("Name", name);
        billContent.put("Number", number);
        billContent.put("Provider", provider);
        billContent.put("Date", date);
        billContent.put("Previous Reading", previousReading);
        billContent.put("Current Reading", currentReading);
        billContent.put("Total Amount", totalAmount);
        billContent.put("Customer Service", customerService);
        return billContent;
    }

    //Fake Random Date for bill content
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
}
