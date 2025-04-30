import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;

public class TransactionViewer {

    public static void displayTransactions(List<Transaction> transactionList, int ledgerMenuChoice) {
        Collections.reverse(transactionList); // Reverse list once

        System.out.println("\nViewing transactions:\n");

        for (Transaction transaction : transactionList) {
            BigDecimal amount = transaction.getAmount();

            switch (ledgerMenuChoice) {
                case 1: // All
                    System.out.println(Transaction.objectToString(transaction));
                    break;

                case 2: // Deposits only
                    if (amount.signum() == 1) {
                        System.out.println(Transaction.objectToString(transaction));
                    }
                    break;

                case 3: // Payments only
                    if (amount.signum() == -1) {
                        System.out.println(Transaction.objectToString(transaction));
                    }
                    break;

                case 4:
                    // Reserved for future or “Go back” action
                    break;

                default:
                    System.out.println("Invalid choice, please choose 1, 2, 3, or 4.");
                    break;
            }
        }
    }
}

