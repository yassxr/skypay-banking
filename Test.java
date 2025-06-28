import java.util.Scanner;

public class InteractiveBanking {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Account account = new Account();
        
        System.out.println("=== Welcome to Simple Banking System ===");
        System.out.println("Commands:");
        System.out.println("  deposit [amount] - e.g., 'deposit 1000'");
        System.out.println("  withdraw [amount] - e.g., 'withdraw 500'");
        System.out.println("  statement - show your bank statement");
        System.out.println("  balance - show current balance");
        System.out.println("  exit - quit the program");
        System.out.println();
        
        while (true) {
            System.out.print("Enter command: ");
            String input = scanner.nextLine().trim();
            
            if (input.equals("exit")) {
                System.out.println("Thank you for using Simple Banking System!");
                break;
            }
            
            try {
                String[] parts = input.split(" ");
                String command = parts[0].toLowerCase();
                
                switch (command) {
                    case "deposit":
                        if (parts.length != 2) {
                            System.out.println("Usage: deposit [amount]");
                            break;
                        }
                        int depositAmount = Integer.parseInt(parts[1]);
                        account.deposit(depositAmount);
                        System.out.println("✓ Deposited " + depositAmount + ". New balance: " + account.getBalance());
                        break;
                        
                    case "withdraw":
                        if (parts.length != 2) {
                            System.out.println("Usage: withdraw [amount]");
                            break;
                        }
                        int withdrawAmount = Integer.parseInt(parts[1]);
                        account.withdraw(withdrawAmount);
                        System.out.println("✓ Withdrew " + withdrawAmount + ". New balance: " + account.getBalance());
                        break;
                        
                    case "statement":
                        System.out.println("\n--- Your Bank Statement ---");
                        account.printStatement();
                        System.out.println("--- End of Statement ---\n");
                        break;
                        
                    case "balance":
                        System.out.println("Current balance: " + account.getBalance());
                        break;
                        
                    default:
                        System.out.println("Unknown command. Try: deposit, withdraw, statement, balance, or exit");
                }
                
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number for the amount.");
            } catch (IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage());
            } catch (Exception e) {
                System.out.println("Something went wrong. Please try again.");
            }
            
            System.out.println();
        }
        
        scanner.close();
    }
}
