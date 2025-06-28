// Transaction.java
import java.time.LocalDate;

public class Transaction {
    private final LocalDate date;
    private final int amount;
    private final String type;
    private final int balanceAfter;
    
    public Transaction(LocalDate date, int amount, String type, int balanceAfter) {
        this.date = date;
        this.amount = amount;
        this.type = type;
        this.balanceAfter = balanceAfter;
    }
    
    public LocalDate getDate() { 
        return date; 
    }
    
    public int getAmount() { 
        return amount; 
    }
    
    public String getType() { 
        return type; 
    }
    
    public int getBalanceAfter() { 
        return balanceAfter; 
    }
}