package GUI;

import Authentication.SessionManager;
import Utility.PasswordValidator;
import Utility.PhoneNumberValidator;
import Utility.Validator;
import Application.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Base64;
import java.util.Scanner;

public class GUI {
    private static final String RED = "\u001B[31m";
    private static final String GREEN = "\u001B[32m";
    private static final String CYAN = "\u001B[36m";
    private static final String RESET = "\u001B[0m";
    private final Scanner scanner = new Scanner(System.in);
    private Application application = new Application();

    public void menuScreen() {
        while(true){
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

    public void signUpScreen() {
        String form = " ".repeat(20) + "<<< Registration Form Page >>>\n";
        form += " Some Notes: \n Password Rules: at least one small, capital, number, symbol is needed" +
                " \n Phone Rules: must start with valid prefixes eg:{010,011,012,015} \n";
        displayMessage(form, 'W');

        boolean isRegistered = false;
        do {
            String userName = takeUserNameInput();
            String password = takePasswordInput();
            String phoneNumber = takePhoneNumberInput();
            isRegistered = application.signUp(userName, password, "111", phoneNumber);
        } while (!isRegistered);
    }

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

    public Integer signedInMenuScreen() {
        String form = "";
        form += " ".repeat(6) + " <<< Available Options >>> \n" +
                "1. Transfer to Bank. \n" +
                "2. Transfer to Account.\n" +
                "3. Transfer to Wallet.\n" +
                "4. Pay Bill.\n" +
                "5. Logout.\n";
        return getInteger(form, 5);
    }

    public void payBillScreen() {
        String form = "";
        form += " ".repeat(6) + " <<< Available Options >>> \n" +
                "1. Electricity bill \n" +
                "2. Water bill\n" +
                "3. Gas bill.\n" +
                "4. Go-Back.\n";
        Integer input = getInteger(form, 4);
        switch (input) {
            case 1 -> {
                application.payBill("electricty", "111");
            }
            case 2 -> {
                application.payBill("water", "222");
            }
            case 3 -> {
                application.payBill("gas", "123");
            }
            case 4 -> {
                return;
            }
        }
    }

    public Integer confirmTransactionScreen() {
        String form = "";
        form += " ".repeat(6) + " <<< Available Options >>> \n" +
                "1. Confirm. \n" +
                "2. Cancel\n";
        return getInteger(form, 2);
    }

    public void loadProfileScreen() {
        String form = "";
        form += "Name: " + SessionManager.getCurrentUser().getName() + "\n"
                + "mobile: " + SessionManager.getCurrentUser().getMobileNumber() +
                "\n" + "Provider Name: " + SessionManager.getCurrentUser().getAccount().getProviderName()
                + "\n" + "Provider Type: "
                + SessionManager.getCurrentUser().getAccount().getProviderType() + "\n";
        displayMessage(form, 'W');
    }

    public void transferToBank() {
        System.out.print("Enter amount to be transferred: ");
        double amount = scanner.nextInt();

        System.out.print("Enter receiver Account number: ");
        String receiverAccountNumber = scanner.nextLine();
        application.transferToBank(amount, receiverAccountNumber);
    }

    public void transferToAccount() {
        System.out.print("Enter amount to be transferred: ");
        double amount = scanner.nextInt();

        System.out.print("Enter receiver Account name: ");
        String receiverAccountName = scanner.nextLine();
        application.transferToAccount(amount, receiverAccountName);
    }

    public void transferToWallet() {
        System.out.print("Enter amount to be transferred: ");
        double amount = scanner.nextInt();

        System.out.print("Enter receiver Account number: ");
        String receiverAccountNumber = scanner.nextLine();
        application.transferToWallet(amount, receiverAccountNumber);
    }

    public void exitScreen() {
        String exitStr = "Thank You For Using our Application ! \n" +
                "Authors: \n  " +
                "Mohamed Essam. \n  " +
                "Alan Samir. \n  " +
                "Mina Hakim. \n" +
                "Salah Eddin. \n";
        displayMessage(exitStr, 'G');
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

    public String takeUserNameInput() {
        System.out.print("Enter UserName: ");
        String userName = scanner.nextLine();
        return userName;
    }

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
            } else {
                String encodedPassword = Base64.getEncoder().encodeToString(pass.getBytes());
                return encodedPassword;
            }
        } while (!pass.equals(passConfirm));

        String encodedPassword = Base64.getEncoder().encodeToString(pass.getBytes());
        return encodedPassword;
    }

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
