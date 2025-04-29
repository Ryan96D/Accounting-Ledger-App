import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;

public class ReadTransactions {

    public static void readFromCSV(String file, int ledgerMenuChoice) {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader("Transactions.csv"))) {
            String csvLine;

            while ((csvLine = bufferedReader.readLine()) !=null){
                String [] transactionInformation = csvLine.split(",");

                String date = transactionInformation [0];
                String time = transactionInformation [1];
                String description = transactionInformation [2];
                String vendor = transactionInformation [3];
                BigDecimal amount = new BigDecimal(transactionInformation [4]);

                switch (ledgerMenuChoice){
                    case 1:
                        System.out.println("Viewing transactions: ");
                        System.out.println(Transaction.csvToString(date,time,description,vendor,amount));
                        break;
                    case 2:
                        System.out.println("Viewing transactions: ");
                        if (amount.signum() == 1) { //Only prints positives
                            System.out.println(Transaction.csvToString(date,time,description,vendor,amount));
                        }
                        break;
                    case 3:
                        System.out.println("Viewing transactions: ");
                        if (amount.signum() == -1){ //Only prints negatives
                            System.out.println(Transaction.csvToString(date,time,description,vendor,amount));
                        }
                        break;
                    case 4:
                        break;
                }
            }
        }catch (IOException e){
            System.out.println("Error while reading from CSV file.");
            System.out.println(e.getMessage());;
        }
    }
}
