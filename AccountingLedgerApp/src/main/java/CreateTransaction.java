import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class CreateTransaction {

    public static Transaction createTransaction(Scanner scanner,boolean isItDeposit){
        LocalTime time = null;
        LocalDate date = null;

        while (true){
            System.out.println("Enter the date of this transaction (yyyy-MM-dd): ");
            String userInput = scanner.nextLine();
            try {
                date = LocalDate.parse(userInput);
                break;
            }catch (DateTimeParseException e){
                System.out.println("Incorrect date format. Try again. ");
            }
        }

        while (true){
            System.out.println("Enter the time of this transaction (HH:mm): ");
            String userInput = scanner.nextLine();
            try {
                time = LocalTime.parse(userInput);
                break;
            }catch (DateTimeParseException e){
                System.out.println("Incorrect date format. Try again. ");
            }
        }
        System.out.println("Enter a description/name for the transaction: ");
        String description = scanner.nextLine();

        System.out.println("Enter the vendor/person this transaction is with: ");
        String vendor = scanner.nextLine();

        BigDecimal amount = BigDecimal.ZERO;
        while (true){
            System.out.println("Enter the amount/price for this transaction");
            String userInput = scanner.nextLine();
            try {
                amount = new BigDecimal(userInput).setScale(2, RoundingMode.HALF_UP); //parse string into BigDecimal and set to 2 decimal points

                if (!isItDeposit){ //If it is not a deposit, but a payment instead
                    amount = amount.negate(); //convert to negative for payments
                }
                break;
            }catch (NumberFormatException e){
                System.out.println("Not a number, try again.");
            }
        }

        return new Transaction(date,time,description,vendor,amount);
    }


}
