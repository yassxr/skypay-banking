// Account.java
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Account implements AccountService {
    private int balance;
    private final List<Transaction> transactions;
    private final DateTimeFormatter dateFormatter;
    
    public Account() {
        this.balance = 0;
        this.transactions = new ArrayList<>();
        this.dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    }
    
    @Override
    public void deposit(int amount) {
        validateAmount(amount, "Deposit");
        
        balance += amount;
        Transaction transaction = new Transaction(
            LocalDate.now(), 
            amount, 
            "DEPOSIT", 
            balance
        );
        transactions.add(transaction);
    }
    
    @Override
    public void withdraw(int amount) {
        validateAmount(amount, "Withdrawal");
        
        if (amount > balance) {
            throw new IllegalArgumentException("Insufficient funds. Current balance: " + balance);
        }
        
        balance -= amount;
        Transaction transaction = new Transaction(
            LocalDate.now(), 
            amount, 
            "WITHDRAWAL", 
            balance
        );
        transactions.add(transaction);
    }
    
    @Override
    public void printStatement() {
        System.out.println("DATE | AMOUNT | BALANCE");
        
        // Print transactions in reverse chronological order (most recent first)
        List<Transaction> reversedTransactions = new ArrayList<>(transactions);
        Collections.reverse(reversedTransactions);
        
        for (Transaction transaction : reversedTransactions) {
            String formattedDate = transaction.getDate().format(dateFormatter);
            String amountStr = (transaction.getType().equals("WITHDRAWAL") ? "-" : "") + transaction.getAmount();
            System.out.println(formattedDate + " | " + amountStr + " | " + transaction.getBalanceAfter());
        }
    }
    
    // Helper method for input validation
    private void validateAmount(int amount, String operation) {
        if (amount <= 0) {
            throw new IllegalArgumentException(operation + " amount must be positive. Received: " + amount);
        }
    }
    
    // Additional helper methods for testing and account management
    public int getBalance() {
        return balance;
    }
    
    public int getTransactionCount() {
        return transactions.size();
    }
    
    // Method to simulate transactions on specific dates (for testing purposes)
    public void depositOnDate(int amount, LocalDate date) {
        validateAmount(amount, "Deposit");
        
        balance += amount;
        Transaction transaction = new Transaction(date, amount, "DEPOSIT", balance);
        transactions.add(transaction);
    }
    
    public void withdrawOnDate(int amount, LocalDate date) {
        validateAmount(amount, "Withdrawal");
        
        if (amount > balance) {
            throw new IllegalArgumentException("Insufficient funds. Current balance: " + balance);
        }
        
        balance -= amount;
        Transaction transaction = new Transaction(date, amount, "WITHDRAWAL", balance);
        transactions.add(transaction);
    }
}