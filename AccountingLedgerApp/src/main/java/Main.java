import java.util.Scanner;

public class Main {
static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {

        showHomeScreen();

    }

    public static void showHomeScreen() {

        while (true) {
            System.out.println("\nMain Menu:\n" +
                    "(1) Add deposit \n" +
                    "(2) Make Payment \n" +
                    "(3) View Ledger \n" +
                    "(4) Exit and Save");

            int homeMenuChoice = 0;

            try {
                homeMenuChoice = Integer.parseInt(scanner.nextLine()); //This try-catch validates that user input is an int
            } catch (NumberFormatException e) {
                System.out.println("Invalid choice, please choose 1,2,3, or 4.");
            }

            switch (homeMenuChoice) {

                case 1: //Deposit
                    Transaction deposit = CreateTransaction.createTransaction(scanner, true);
                    SaveTransaction.saveTransaction(deposit,"Transactions.csv");
                    break;

                case 2: //Payments
                    Transaction payment = CreateTransaction.createTransaction(scanner, false);
                    SaveTransaction.saveTransaction(payment,"Transactions.csv");
                    break;

                case 3: //Open Ledger
                    Ledger.displayLedgerMenu(scanner);
                    break;

                case 4: //Exit App
                    System.out.println("Exiting the app and saving...");
                    scanner.close();
                    System.out.println("Have a great day!");
                    return;
                default:
                    System.out.println("Invalid choice, please choose 1,2,3, or 4.");
            }
        }
    }


}



