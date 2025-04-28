import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
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
        List<Transaction> transaction = new ArrayList<Transaction>(); //Make an arraylist to store transactions before saving

        while (true) {
            System.out.println("\nMain Menu:\n" +
                    "(1) Add deposit \n" +
                    "(2) Make Payment \n" +
                    "(3) View Ledger \n" +
                    "(4) Exit");

            int homeMenuChoice = 0;

            try {
                homeMenuChoice = Integer.parseInt(scanner.nextLine()); //This try-catch validates that user input is an int
            } catch (NumberFormatException e) {
                System.out.println("Invalid choice, please choose 1,2,3, or 4.");

            }

            switch (homeMenuChoice) {
                case 1: //Deposit
                    Transaction deposit = CreateTransaction.createTransaction(scanner, true);
                    transaction.add(deposit);
                    break;
                case 2: //Payments
                    Transaction payment = CreateTransaction.createTransaction(scanner, false);
                    transaction.add(payment);
                    break;
                case 3: //Open Ledger
                    System.out.println("Viewing all transactions:");
                    for (int i = 0; i < transaction.size(); i++) {
                        Transaction localTransaction = transaction.get(i);
                        System.out.println("("+(i+1)+")"+ Transaction.transactionString(localTransaction));
                    }
                    break;
                case 4: //Exit App
                    System.out.println("Exiting the app...");
                    scanner.close();
                    System.out.println("Have a great day!");
                    break;
                default:
                    System.out.println("Invalid choice, please choose 1,2,3, or 4.");
            }
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



