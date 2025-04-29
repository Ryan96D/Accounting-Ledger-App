import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class SaveTransaction {

    public static void saveTransaction(List<Transaction> transactionList, String file){
        FileWriter fileWriter = null;

        try{
            fileWriter = new FileWriter("Transactions.csv",true);
            for (int i = 0; i < transactionList.size(); i++){
                Transaction localTransaction = transactionList.get(i);
                String csvLine = localTransaction.convertCSV();
                fileWriter.write(csvLine +"\n");
            }
        }catch (IOException e){
            System.out.println("Saving transaction to CSV error");
            System.out.println(e.getMessage());
        }finally {
            try {
                if (fileWriter!=null) { //Closes fileWriter when it's done writing/ nothing else to write
                    fileWriter.close();
                }
            }catch (IOException e){
                System.out.println("Closing FileWriter error");
                System.out.println(e.getMessage());
            }
        }


    }
}
