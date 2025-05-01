# 📒 Account Ledger Application

The Account Ledger Application is a console-based Java program built to log and manage financial transactions. It supports tracking deposits and payments, generating financial reports, and viewing data from a ledger stored in a CSV file.

Developed as part of the **Year Up United** program by **Ryan Do**, this project demonstrates practical Java skills, including modular design, input validation, and file handling.

---

## 🧰 Features

- ✅ Add deposits or payments
- 📄 Automatically saves to a CSV file (`Transactions.csv`)
- 📂 View:
  - All transactions
  - Deposits only
  - Payments only
- 📊 Reports:
  - Month to current date
  - Previous month
  - Year to current date
  - Previous year
  - Filter by vendor
- 🧠 Input validation to prevent crashes or invalid data

---

## 🖥️ Technologies Used

| Tool        | Version     |
|-------------|-------------|
| Java        | JDK 24      |
| IDE         | IntelliJ IDEA |
| Build Tool  | Maven       |
| Libraries   | None        |

---

## 📁 File Structure
. ├── Main.java # Program entry point and home menu ├── Ledger.java # Ledger menu and transaction viewing logic ├── Reports.java # Transaction reports and filters ├── CreateTransaction.java # Handles user input for new transactions ├── Transaction.java # Transaction model class ├── SaveTransaction.java # Saves transactions to CSV ├── ReadTransactions.java # Reads transactions from CSV └── Transactions.csv # Ledger data (auto-created if not present)


---

## ▶️ How to Run

1. Clone or download the project to your machine.
2. Open the project in IntelliJ IDEA.
3. Make sure you're using **JDK 24**.
4. Open `Main.java` and run the file.

---

## ✏️ Example Transactions (CSV Format)

```csv
2025-04-25,10:00,Paycheck,Employer,1500.00
2025-04-26,14:15,Grocery Store,Walmart,-55.75
2025-04-27,09:30,Coffee,Dunkin Donuts,-3.25

Main Menu:
(1) Add deposit
(2) Make Payment
(3) View Ledger
(4) Exit and Save

Viewing transactions:

Date: 2025-04-27 || Time: 09:30 || Description: Coffee || Vendor: Dunkin Donuts || Amount: -3.25
Date: 2025-04-26 || Time: 14:15 || Description: Grocery Store || Vendor: Walmart || Amount: -55.75
Date: 2025-04-25 || Time: 10:00 || Description: Paycheck || Vendor: Employer || Amount: 1500.00

🧑‍💻 Author
Ryan Do
Software Development Track – Year Up United

📌 Notes
All transactions are stored in Transactions.csv

If the CSV does not exist, it will be created automatically

Only valid transactions are saved; invalid input is rejected with prompts

📦 Optional Enhancements (Coming in the future)
Automatically use current date/time (planned feature)

GUI version using JavaFX or web-based frontend

Exporting filtered reports to new CSV files



