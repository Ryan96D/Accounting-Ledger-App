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
        int homeMenuChoice;
        // Show options like:
        // - Add Deposit
        // - Make Payment
        // - View Ledger
        // - Exit
        // Handle user input and call other methods based on the choice
        System.out.println("(1) Add deposit \n" +
                "(2) Make Payment \n" +
                "(3) View Ledger \n" +
                "(4) Exit");
        homeMenuChoice = scanner.nextInt();


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



