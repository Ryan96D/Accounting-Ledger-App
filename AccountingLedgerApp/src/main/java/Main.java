import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeParseException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {

        // Start the program
        // Show the main menu
        showHomeScreen();

        // Keep running until the user chooses to exit (Loop)
    }

    public static void showHomeScreen() {

        // Show options like:
        // - Add Deposit
        // - Make Payment
        // - View Ledger
        // - Exit
        // Handle user input and call other methods based on the choice
        System.out.println("\nMain Menu:\n" +
                "(1) Add deposit \n" +
                "(2) Make Payment \n" +
                "(3) View Ledger \n" +
                "(4) Exit");

        int homeMenuChoice = 0;

        try{
            homeMenuChoice = Integer.parseInt(scanner.nextLine()); //This try-catch validates that user input is an int
        }catch (NumberFormatException e){
            System.out.println("Invalid choice, please choose 1,2,3, or 4.");

        }

        switch (homeMenuChoice) {
            case 1: //Deposit
                break;
            case 2: //Payments
                break;
            case 3: //Open Ledger
                break;
            case 4: //Exit App
                break;
            default:
                System.out.println("Invalid choice, please choose 1,2,3, or 4.");


        }

    }


    private static void addDeposit() {
        // Ask the user for deposit details
        // Create a new transaction and save it to csv
    }

    private static void makePayment() {
        // Ask the user for payment details
        // Create a new transaction and save it to csv
    }

    private static void showLedger() {
        // Show options to filter transactions (show all, only deposits, or only payments)
    }


}



