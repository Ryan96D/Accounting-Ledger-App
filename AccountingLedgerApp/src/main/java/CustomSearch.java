import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class CustomSearch {

    public static void search(Scanner scanner) {
        System.out.println("Leave any field blank to skip filtering by that field.");

        LocalDate startDate = null; //auto set to null to skip if nothing is entered
        LocalDate endDate = null;
        String description = "";
        String vendor = "";
        BigDecimal minAmount = null;
        BigDecimal maxAmount = null;


        try {
            System.out.print("Start Date (yyyy-MM-dd): ");
            String userInput = scanner.nextLine().trim();
            if (!userInput.isEmpty()) {
                startDate = LocalDate.parse(userInput);
            }

            System.out.print("End Date (yyyy-MM-dd): ");
            userInput = scanner.nextLine().trim();
            if (!userInput.isEmpty()) {
                endDate = LocalDate.parse(userInput);
            }

            System.out.print("Description: ");
            description = scanner.nextLine().trim().toLowerCase();

            System.out.print("Vendor: ");
            vendor = scanner.nextLine().trim().toLowerCase();

            System.out.print("Minimum Amount: ");
            String minInput = scanner.nextLine().trim();
            if (!minInput.isEmpty()) {
                minAmount = new BigDecimal(minInput);
            }

            System.out.print("Maximum Amount: ");
            String maxInput = scanner.nextLine().trim();
            if (!maxInput.isEmpty()) {
                maxAmount = new BigDecimal(maxInput);
            }

        } catch (DateTimeParseException | NumberFormatException e) {
            System.out.println("Invalid input. Please try again.");
            return;
        }

        System.out.println("\nSearch Results:\n");

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader("Transactions.csv"))) {
            String csvLine;

            while ((csvLine = bufferedReader.readLine()) != null) {
                Transaction transactionObject = Transaction.csvToObject(csvLine);
                if (transactionObject == null) continue;

                boolean matches = true; //default to true so that we can filter

                if (startDate != null && transactionObject.getDate().isBefore(startDate)) matches = false; //if object date is before start date, false
                if (endDate != null && transactionObject.getDate().isAfter(endDate)) matches = false;
                if (!description.isEmpty() && !transactionObject.getDescription().toLowerCase().contains(description)) matches = false;
                if (!vendor.isEmpty() && !transactionObject.getVendor().toLowerCase().contains(vendor)) matches = false;
                if (minAmount != null && transactionObject.getAmount().compareTo(minAmount) < 0) matches = false; //compareTo returns boolean (1/0/-1)(>/=/<
                if (maxAmount != null && transactionObject.getAmount().compareTo(maxAmount) > 0) matches = false;


                if (matches) {
                    System.out.println(Transaction.objectToString(transactionObject)); // if passes all checks
                }
            }

        } catch (IOException e) {
            System.out.println("File read error: " + e.getMessage());
        }
    }
}