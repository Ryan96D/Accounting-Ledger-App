import java.time.LocalDate;
import java.time.LocalTime;

public class Transaction {

    // Info about one transaction:
    // - Date
    // - Time
    // - Description
    // - Vendor
    // - Amount (can be positive or negative)
    private LocalDate date;
    private LocalTime time;
    private String description;
    private String vendor;
    private double amount;

    // Make a constructor to create a transaction

    public Transaction(LocalDate date, LocalTime time, String description, String vendor, double amount) {
        this.date = date;
        this.time = time;
        this.description = description;
        this.vendor = vendor;
        this.amount = amount;
    }

    // A method to turn a Transaction into a CSV line



    // A method to turn a CSV line into a Transaction


    // Maybe a method to print the transaction nicely


}