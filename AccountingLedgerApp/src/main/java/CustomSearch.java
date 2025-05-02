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

        LocalDate startDate = null;
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
                Transaction transaction = Transaction.csvToObject(csvLine);
                if (transaction == null) continue;

                boolean matches = true;

                if (startDate != null && transaction.getDate().isBefore(startDate)) matches = false;
                if (endDate != null && transaction.getDate().isAfter(endDate)) matches = false;
                if (!description.isEmpty() && !transaction.getDescription().toLowerCase().contains(description)) matches = false;
                if (!vendor.isEmpty() && !transaction.getVendor().toLowerCase().contains(vendor)) matches = false;
                if (minAmount != null && transaction.getAmount().compareTo(minAmount) < 0) matches = false;
                if (maxAmount != null && transaction.getAmount().compareTo(maxAmount) > 0) matches = false;


                if (matches) {
                    System.out.println(Transaction.objectToString(transaction));
                }
            }

        } catch (IOException e) {
            System.out.println("File read error: " + e.getMessage());
        }
    }
}