package GUI;

import Authentication.SessionManager;
import User.ProviderName;
import User.ProviderType;
import User.User;
import Utility.PasswordValidator;
import Utility.PhoneNumberValidator;
import Utility.UserNameValidator;
import Utility.Validator;
import Application.*;
import Bill.Bill;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Base64;
import java.util.Scanner;

public class GUI {
    private static final String RED = "\u001B[31m";
    private static final String GREEN = "\u001B[32m";
    private static final String CYAN = "\u001B[36m";
    private static final String YELLOW = "\u001B[33m";
    private static final String RESET = "\u001B[0m";
    private final Scanner scanner = new Scanner(System.in);
    private Application application = new Application();

    public void menuScreen() {
        while (true) {
            String dashedLine = "-".repeat(28 + 2);
            System.out.print('+');
            System.out.print(dashedLine);
            System.out.println('+');
            String mainMenuStr = "|" + " ".repeat(5) + CYAN + " InstaPay PROJECT"
                    + RESET + " ".repeat(8) + "|\n" +
                    "| 1.Log-In" + " ".repeat(21) + "|\n" +
                    "| 2.Register" + " ".repeat(19) + "|\n" +
                    "| 3.Exit" + " ".repeat(23) + "|\n";
            System.out.print(mainMenuStr);
            System.out.print('+');
            System.out.print(dashedLine);
            System.out.println('+');

            Integer option = getInteger("", 3);
            switch (option) {
                case 1 -> {
                    loginScreen();
                }
                case 2 -> {
                    signUpScreen();
                }
                case 3 -> {
                    exitScreen();
                    return;
                }
            }
        }
    }


//------------------------------RegistrationFunctions-----------------------------------------
    public void signUpScreen() {
        String form = " ".repeat(20) + "<<< Registration Form Page >>>\n";
        form += " Some Notes: \n Password Rules: at least one small, capital, number, symbol is needed" +
                " \n Phone Rules: must start with valid prefixes eg:{010,011,012,015} \n";
        displayMessage(form, 'W');

        boolean isRegistered = false;
        do {
            String userName = takeUserNameInput();
            String password = takePasswordInput();
//            String phoneNumber = takePhoneNumberInput();

            // implement taking acocunt type
            Integer typeOption = getInteger("Enter account type:\n1-Bank\n2-Wallet\n", 2);
            String type = null;
            ProviderType providerType = null;
            ProviderName providerName = null;
            switch (typeOption) {
                case 1 -> {
                    type = "Bank";
                    providerType = ProviderType.BANK;
                }
                case 2 -> {
                    type = "Wallet";
                    providerType = ProviderType.WALLET;
                }
            }

            switch (providerType){
                case BANK -> {
                    providerName = ProviderName.BANK;
                }
                case WALLET -> {
                    typeOption = getInteger("Choose Type of Wallet: \n1-Vodafone Cash" +
                            "\n2-Fawry",2);
                    switch (typeOption){
                        case 1 -> providerName = ProviderName.VODAFONECASH;
                        case 2 -> providerName = ProviderName.FAWRY;
                    }
                }
            }

            SignUpStrategy signUpScreen = SignUpFactory.createSignUpMethod(type);
            signUpScreen.showSignUpScreen();

            String bankNumber = signUpScreen.getProviderNum();
            String phoneNumber = signUpScreen.getPhoneNum();

            displayMessage(application.sendOTP(phoneNumber),'W');

            System.out.print("Enter OTP sent to your phone: ");
            String otp = scanner.nextLine();

            isRegistered = application.signUp(userName, password, bankNumber, phoneNumber, otp,
                    providerType, providerName);

            if(!isRegistered){
                displayMessage("Something went wrong, Please try again!",'R');
            }
        } while (!isRegistered);
        displayMessage("Registration Complete!",'C');
    }
    public String takeUserNameInput() {
        Boolean isValid;
        String userName;
        do {
            System.out.print("Enter UserName: ");
            userName = scanner.nextLine();
            Validator validator = new UserNameValidator();
            isValid = validator.validate(userName);
            if (!isValid) {
                displayMessage("Username must be morethan 5 character " +
                        "and not existing before", 'R');
            }
        }while(!isValid);

        return userName;
    } // Done

    public String takePasswordInput() {
        Validator validator = new PasswordValidator();
        String pass, passConfirm;
        do {
            boolean isValidPass;
            do {
                System.out.print("Enter Password: ");
                pass = scanner.nextLine();
                isValidPass = validator.validate(pass);
                if (!isValidPass) {
                    displayMessage("Password is not Strong Enough", 'R');
                }
            } while (!isValidPass);

            System.out.print("Confirm Password: ");
            passConfirm = scanner.nextLine();

            if (!pass.equals(passConfirm)) {
                displayMessage("Passwords Don't Match!", 'R');
            }
        } while (!pass.equals(passConfirm));

        return pass;
    } // Done

    public String takePhoneNumberInput() {
        Validator validator = new PhoneNumberValidator();
        boolean isValidPhone;
        do {
            System.out.print("Enter Phone Number: ");
            String phoneNumber = scanner.nextLine();
            isValidPhone = validator.validate(phoneNumber);
            if (!isValidPhone) {
                displayMessage("Phone number isn't Correct", 'R');
            } else {
                return phoneNumber;
            }
        } while (!isValidPhone);
        return null;
    }

//---------------------------------------------------------------------------

//---------------------------Login & Signed in screen-------------------
    public void loginScreen() {
        displayMessage("Welcome to Login Page", 'W');
        System.out.print("Enter Username: ");
        String userName = scanner.nextLine();

        System.out.print("Enter Password: ");
        String password = scanner.nextLine();

        boolean isFound = SessionManager.signIn(userName, password);
        if (isFound) {
            displayMessage("Welcome, " + userName, 'C');
            signedInMenuScreen();
        } else {
            loginFailed();
        }
    }

    public void signedInMenuScreen(){
        while (true) {
            String form = "";
            form += " ".repeat(3) + " <<< Available Options >>> \n" +
                    "1. Transfer to Account. \n";

            ProviderType providerType = SessionManager.getCurrentUser().getAccount().getProviderType();
            Integer option;
            if(providerType.equals(ProviderType.BANK)){
                form += "2. Transfer to Bank.\n" +
                        "3. Transfer to Wallet.\n" +
                        "4. Inquire Balance. \n" +
                        "5. Pay Bill.\n" +
                        "6. Profile Info. \n" +
                        "7. Logout.\n";
                option = getInteger(form, 7);
                if(!bankOptions(option)) return;
            }
            else{
                form += "2. Transfer to Wallet.\n" +
                        "3. Inquire Balance. \n" +
                        "4. Pay Bill.\n" +
                        "5. Profile Info. \n" +
                        "6. Logout.\n";
                option = getInteger(form, 6);
                if(!walletOption(option))return;
            }

            try {
                Thread.sleep(1500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
    public boolean bankOptions(Integer option){
        switch (option) {
            case 1 -> {
                transferToAccount();
            }
            case 2 -> {
                transferToBank();
            }
            case 3 -> {
                transferToWallet();
            }
            case 4 ->{
                inquireBalance();
            }
            case 5 -> {
                payBillScreen();
            }
            case 6 -> {
                loadProfileScreen();
            }
            case 7 -> {
                logOut();
                return false;
            }
        }
        return true;
    }
    public boolean walletOption(Integer option){

        switch (option) {
            case 1 -> {
                transferToAccount();
            }
            case 2 -> {
                transferToWallet();
            }
            case 3 -> {
                inquireBalance();
            }
            case 4 -> {
                payBillScreen();
            }
            case 5 -> {
                loadProfileScreen();
            }
            case 6 -> {
                logOut();
                return false;
            }
        }
        return true;
    }

//---------------------------------------------------------------------------
    public void payBillScreen() {
        String form = "";
        form += " ".repeat(6) + " <<< Available Options >>> \n" +
                "1. Electricity bill \n" +
                "2. Water bill\n" +
                "3. Gas bill.\n" +
                "4. Go-Back.\n";
        Integer input = getInteger(form, 4);
        Bill bill = null;
        switch (input) {
            case 1 -> {
                bill = application.showBillContent("electricity", "111");
            }
            case 2 -> {
                bill = application.showBillContent("water", "222");
            }
            case 3 -> {
                bill = application.showBillContent("gas", "123");
            }
            case 4 -> {
                return;
            }
        }
        if(bill != null){
            displayMessage(bill.display(),'W');
            confirmTransactionScreen();
            application.payBill(bill);
        }
        displayMessage("Bill has been Paid successfully", 'C');
    }

    public boolean confirmTransactionScreen() {
        String form = "";
        form += " ".repeat(6) + " <<< Available Options >>> \n" +
                "1. Confirm. \n" +
                "2. Cancel\n";
        return getInteger(form, 2) == 1;
    }

    public void loadProfileScreen() {
        String form = "";
        form += "Name: " + SessionManager.getCurrentUser().getName() + "\n"
                + "mobile: " + SessionManager.getCurrentUser().getMobileNumber() +
                "\n" + "Provider Name: " + SessionManager.getCurrentUser().getAccount().getProviderName()
                + "\n" + "Provider Type: "
                + SessionManager.getCurrentUser().getAccount().getProviderType() + "\n";
        displayMessage(form, 'G');
    }

    public void transferToBank() {
        System.out.print("Enter amount to be transferred: ");
        double amount = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter receiver Account number: ");
        String receiverAccountNumber = scanner.next();
        if (confirmTransactionScreen()) {
            if (application.transferToBank(amount, receiverAccountNumber)) {
                displayMessage("Transaction succeeded",'C');
            } else {
                displayMessage("Transaction failed",'R');
            }
        }
    }

    public void inquireBalance(){
        Double balance = application.inquireBalance();
        displayMessage("Your Balance: " + balance, 'Y');
    }

    public void transferToAccount() {
        System.out.print("Enter amount to be transferred: ");
        double amount = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter receiver Account name: ");
        String receiverAccountName = scanner.nextLine();
        if (confirmTransactionScreen()) {
            if (application.transferToAccount(amount, receiverAccountName)) {
                displayMessage("Transaction succeeded",'C');
            } else {
                displayMessage("Transaction failed",'R');
            }
        }
    }

    public void transferToWallet() {
        System.out.print("Enter amount to be transferred: ");
        double amount = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter receiver Account number: ");
        String receiverAccountNumber = scanner.nextLine();
        if (confirmTransactionScreen()) {
            if (application.transferToWallet(amount, receiverAccountNumber)) {
                displayMessage("Transaction succeeded",'C');
            } else {
                displayMessage("Transaction failed",'R');
            }
        }
    }

    public void exitScreen() {
        String exitStr = "Thank You For Using our Application ! \n" +
                "Authors: \n  " +
                "Mohamed Essam. \n  " +
                "Alan Samir. \n  " +
                "Mina Hakim. \n" +
                "  Salah Eddin. \n";
        displayMessage(exitStr, 'G');
    }

    public void logOut(){
        displayMessage("You have logged out",'C');
    }
    public void loginFailed() {
        displayMessage("User isn't Found in the System !", 'R');
    }

    public void userNotRegistered() {
        displayMessage("Can't Access, You are not registered! \n", 'R');
    }

    public void displayMessage(String message, char color) {
        if (message.isEmpty()) {
            return;
        }
        String[] strArr = message.split("\n");
        int size = Arrays.stream(strArr).map(String::length).max(Integer::compare).get();

        String dashedLine = "-".repeat(size + 2);
        System.out.print('+');
        System.out.print(dashedLine);
        System.out.println('+');

        switch (color) {
            case 'R': {
                for (String msg : strArr) {
                    System.out.println("| " + RED + msg + RESET + " ".repeat(size - msg.length()) + " |");
                }
                break;
            }
            case 'G': {
                for (String msg : strArr) {
                    System.out.println("| " + GREEN + msg + RESET + " ".repeat(size - msg.length()) + " |");
                }
                break;
            }
            case 'C': {
                for (String msg : strArr) {
                    System.out.println("| " + CYAN + msg + RESET + " ".repeat(size - msg.length()) + " |");
                }
                break;
            }
            case 'Y': {
                for (String msg : strArr) {
                    System.out.println("| " + YELLOW + msg + RESET + " ".repeat(size - msg.length()) + " |");
                }
                break;
            }
            default: {
                for (String msg : strArr) {
                    System.out.println("| " + msg + " ".repeat(size - msg.length()) + " |");
                }
            }
        }

        System.out.print('+');
        System.out.print(dashedLine);
        System.out.println('+');
    }



    public boolean checkCertainNumber(int chosenOption, ArrayList<Integer> availableOptions) {
        for (int i : availableOptions) {
            if (chosenOption != i) {
                continue;
            }
            return true;
        }
        scanner.nextLine();
        displayMessage("Option is not available", 'R');
        return false;
    }

    public void validateIntegerInput(String option) {
        boolean isInt = false;

        while (!isInt) {
            try {
                System.out.print(option);
                isInt = scanner.hasNextInt();
                if (!isInt) throw new IOException();
            } catch (Exception err) {
                scanner.nextLine();
                displayMessage("Please Enter a Number not String !", 'R');
            }
        }
    }

    public Integer getInteger(String info, int optionSize) {
        displayMessage(info, 'W');

        ArrayList<Integer> optionsNumber = new ArrayList<>();
        for (int i = 1; i <= optionSize; ++i) {
            optionsNumber.add(i);
        }

        boolean isValidInput = false;
        while (!isValidInput) {
            validateIntegerInput("Enter Option Number: ");
            Integer choice = scanner.nextInt();
            isValidInput = checkCertainNumber(choice, optionsNumber);

            if (isValidInput) {
                scanner.nextLine();
                return choice;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        Database db = new Database();
        GUI gui = new GUI();
        gui.menuScreen();
    }
}
