import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

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

    private static final DateTimeFormatter yyyyMMdd = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    // A method to turn a Transaction object into a CSV line
    public String objectToCSV(){

        return String.format("%s,%s,%s,%s,%s",date.toString(),time.toString(),description,vendor,amount.setScale(2, RoundingMode.HALF_UP).toString());

    }


    // A method to turn a CSV line into a String (from a csv
    public static String csvToString(String date, String time, String description, String vendor,BigDecimal amount){
        return String.format("Date: %s || Time: %s || Description: %s || Vendor: %s || Amount: %s",
                date,time,description,vendor,amount.toPlainString());
    }


    // A method to convert Transaction to a String (from an object)
    public static String objectToString(Transaction transactionobject){
        return String.format("Date: %s || Time: %s || Description: %s || Vendor: %s || Amount: %s",
                transactionobject.getDate(),transactionobject.getTime(),transactionobject.getDescription(),transactionobject.getVendor(),transactionobject.getAmount());
    }


    public static Transaction csvToObject(String csvLine) {
        String[] transactionInfo = csvLine.split(",");

        if (transactionInfo.length < 5) {
            return null;
        }

        String date = transactionInfo[0];
        String time = transactionInfo[1];
        String description = transactionInfo[2];
        String vendor = transactionInfo[3];
        String amountString = transactionInfo[4];

        LocalDate localDate = ReadTransactions.parseDateFlexible(date);
        if (localDate == null) {
            return null;
        }

        BigDecimal amountBigDecimal = new BigDecimal(amountString);
        LocalTime localTime = LocalTime.parse(time);

        return new Transaction(localDate, localTime, description, vendor, amountBigDecimal);
    }



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