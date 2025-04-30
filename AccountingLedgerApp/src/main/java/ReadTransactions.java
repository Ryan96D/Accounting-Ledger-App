import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ReadTransactions {

    public static List<Transaction> readCSV(String filePath) {
        List<Transaction> transactionList = new ArrayList<>();

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath))) {
            String csvLine;
            while ((csvLine = bufferedReader.readLine()) != null) {
                Transaction transaction = Transaction.csvToObject(csvLine);
                if (transaction != null) {
                    transactionList.add(transaction);
                }
            }
        } catch (IOException e) {
            System.out.println("File read error");
            System.out.println(e.getMessage());
        }

        return transactionList;
    }


}