import java.math.BigDecimal;
import java.math.RoundingMode;
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
    private BigDecimal amount;

    // Make a constructor to create a transaction

    public Transaction(LocalDate date, LocalTime time, String description, String vendor, BigDecimal amount) {
        this.date = date;
        this.time = time;
        this.description = description;
        this.vendor = vendor;
        this.amount = amount;
    }

    // A method to turn a Transaction into a CSV line
    public String convertCSV(){

        return String.format("%s,%s,%s,%s,%.s",date.toString(),time.toString(),description,vendor,amount.setScale(2, RoundingMode.HALF_UP).toString());

    }



    // A method to turn a CSV line into a Transaction


    // Maybe a method to print the transaction nicely


    //Getter methods
    public LocalDate getDate() {
        return date;
    }

    public LocalTime getTime() {
        return time;
    }

    public String getDescription() {
        return description;
    }

    public String getVendor() {
        return vendor;
    }

    public BigDecimal getAmount() {
        return amount;
    }
}