import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Reports {


    public static void showReportsMenu(Scanner scanner){

        System.out.println("\nReports Menu: \n");
        int reportsMenuChoice = 0;
        try {
          reportsMenuChoice= Integer.parseInt(Main.scanner.nextLine());

        }catch (NumberFormatException e){
            System.out.println("Not a valid number");
            System.out.println(e.getMessage());
        }


        }


    public static void monthToDate() {

        LocalDate today = LocalDate.now(); //Makes Current date variable: today
        LocalDate firstDayOfMonth = today.withDayOfMonth(1); // Reuses today and sets it to first day of month

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader("Transactions.csv"))) {
            String csvLine;
            System.out.println("\nCurrent Month to Date Transactions: \n");

            while ((csvLine = bufferedReader.readLine()) != null) {
                Transaction transaction = Transaction.csvToObject(csvLine);

                if (transaction != null) {
                    LocalDate date = transaction.getDate();
                    if ((date.isEqual(firstDayOfMonth) || date.isAfter(firstDayOfMonth)) && (date.isEqual(today) || date.isBefore(today))) {
                        System.out.println(Transaction.objectToString(transaction));

                    }
                }
            }
        } catch (IOException e) {
            System.out.println("File read error");
            System.out.println(e.getMessage());
        }
    }

    public static void previousMonth() {
        LocalDate today = LocalDate.now();
        LocalDate firstDayPreviousMonth = today.minusMonths(1).withDayOfMonth(1);
        LocalDate lastDayPreviousMonth = today.minusMonths(1).withDayOfMonth(today.minusMonths(1).lengthOfMonth()); //Set Month, then day

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader("Transactions.csv"))) {
            String csvLine;
            System.out.println("\nPrevious Month's Transactions: \n");

            while ((csvLine = bufferedReader.readLine()) != null) {
                Transaction transaction = Transaction.csvToObject(csvLine);
                if (transaction != null) {
                    LocalDate date = transaction.getDate();
                    if ((date.isEqual(firstDayPreviousMonth) || date.isAfter(firstDayPreviousMonth)) && (date.isEqual(lastDayPreviousMonth) || date.isBefore(lastDayPreviousMonth))) {
                        System.out.println(Transaction.objectToString(transaction));
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("File read error");
            System.out.println(e.getMessage());
        }
    }

    public static void yearToDate() {
        LocalDate today = LocalDate.now();
        LocalDate firstDayOfYear = today.withDayOfYear(1);

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader("Transactions.csv"))) {
            String csvLine;
            System.out.println("Year to Date Transactions: \n");

            while ((csvLine = bufferedReader.readLine()) != null) {
                Transaction transaction = Transaction.csvToObject(csvLine); // Reuse csvToObject

                if (transaction != null) {
                    LocalDate date = transaction.getDate();
                    if ((date.isEqual(firstDayOfYear) || date.isAfter(firstDayOfYear)) && (date.isEqual(today) || date.isBefore(today))) {
                        System.out.println(Transaction.objectToString(transaction));
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("File read error");
            System.out.println(e.getMessage());
        }
    }

    public static void previousYear() {
        LocalDate today = LocalDate.now();
        LocalDate firstDayOfPreviousYear = today.minusYears(1).withDayOfYear(1);
        LocalDate lastDayOfPreviousYear = today.minusYears(1).withDayOfYear(today.minusYears(1).lengthOfYear());

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader("Transactions.csv"))) {
            String csvLine;
            System.out.println("Previous Year's Transactions: \n");

            while ((csvLine = bufferedReader.readLine()) != null) {
                Transaction transaction = Transaction.csvToObject(csvLine); // Reuse csvToObject

                if (transaction != null) {
                    LocalDate date = transaction.getDate();
                    if ((date.isEqual(firstDayOfPreviousYear) || date.isAfter(firstDayOfPreviousYear)) && (date.isEqual(lastDayOfPreviousYear) || date.isBefore(lastDayOfPreviousYear))) {
                        System.out.println(Transaction.objectToString(transaction));
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("File read error");
            System.out.println(e.getMessage());
        }
    }

    public static void searchByVendor() {
        System.out.print("Enter Vendor Name: ");
        String vendorName = Main.scanner.nextLine().toLowerCase(); // convert to lowercase for case-insensitive search

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader("Transactions.csv"))) {
            String csvLine;
            System.out.println("Transactions for Vendor: " + vendorName + "\n");

            while ((csvLine = bufferedReader.readLine()) != null) {
                Transaction transaction = Transaction.csvToObject(csvLine); // Reuse csvToObject

                if (transaction != null) {
                    String vendor = transaction.getVendor().toLowerCase(); // case-insensitive comparison
                    if (vendor.contains(vendorName)) {
                        System.out.println(Transaction.objectToString(transaction));
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("File read error");
            System.out.println(e.getMessage());
        }
    }
}






