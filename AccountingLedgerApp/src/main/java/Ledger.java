import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Ledger {

    public static void displayLedgerMenu(Scanner scanner){
        while (true) {
            System.out.println("\nLedger Menu: \n" +
                    "(1) All - View all transactions\n" +
                    "(2) Deposits - View Deposits only\n" +
                    "(3) Payments - View Payments only\n" +
                    "(4) Reports - View Reports screen for more search options\n" +
                    "(5) Home - Go back to Home menu \n");

            int ledgerMenuChoice = 0;
            try {
                ledgerMenuChoice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid choice, please choose 1-5");
                continue;
            }
            if (ledgerMenuChoice == 5) {
                // Option 5: Go back to Home menu (exit loop)
                return;
            }
            if (ledgerMenuChoice >= 1 && ledgerMenuChoice <= 4) {
            List<Transaction> transactionList = ReadTransactions.readCSV("Transactions.csv");
            displayTransactions(transactionList, ledgerMenuChoice); //call method
            } else {
                System.out.println("Invalid choice, please choose 1-5");
            }
        }
    }


    public static void displayTransactions(List<Transaction> transactionList, int ledgerMenuChoice) {
        Collections.reverse(transactionList); // Reverse list once

        System.out.println("\nViewing transactions:\n");

        for (Transaction transaction : transactionList) {
            BigDecimal amount = transaction.getAmount();

            switch (ledgerMenuChoice) {
                case 1: // All
                    System.out.println(Transaction.objectToString(transaction));
                    break;

                case 2: // Deposits only
                    if (amount.signum() == 1) {
                        System.out.println(Transaction.objectToString(transaction));
                    }
                    break;

                case 3: // Payments only
                    if (amount.signum() == -1) {
                        System.out.println(Transaction.objectToString(transaction));
                    }
                    break;

                case 4:
                    Reports.showReportsMenu(Main.scanner); //Open Reports Menu

                    break;

                case 5: //return to Home

                    break;

                default:
                    System.out.println("Invalid choice, please choose 1, 2, 3, or 4.");
                    break;
            }
        }
    }
}

//All entries should show the newest entries first
// A) All - Display all entries
// D) Deposits - Display only the entries that are deposits into the account
// P) Payments - Display only the negative entries (or payments)
// R) Reports - A new screen that allows the user to run pre-defined reports or to run a custom search
//      1) Month To Date
//      2) Previous Month
//      3) Year To Date
//      4) Previous Year
//      5) Search by Vendor - prompt the user for the vendor name and display all entries for that vendor
//      0) Back - go back to the report page
// H) Home - go back to the home page