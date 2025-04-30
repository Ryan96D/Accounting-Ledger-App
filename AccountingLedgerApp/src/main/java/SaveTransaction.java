import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class SaveTransaction {

    public static void saveTransaction(Transaction transaction, String file){
        try(FileWriter fileWriter = new FileWriter("Transactions.csv",true)){
            String csvLine = transaction.objectToCSV();
            fileWriter.write(csvLine + "\n"); // Write the CSV line to the file, followed by a newline
        } catch (IOException e) {
            System.out.println("Saving transaction to CSV error");
            System.out.println(e.getMessage());
        }
    }
}