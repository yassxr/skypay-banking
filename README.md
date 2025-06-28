# Skypay Banking Service

A simple banking service implementation built in Java as part of Skypay's technical test.

## 📋 Requirements Met

This implementation fulfills all the technical requirements:

- ✅ **Core Banking Functions**: Deposit, withdraw, and print statements
- ✅ **Interface Implementation**: `Account` class implements `AccountService` interface
- ✅ **Exception Handling**: Validates inputs and prevents invalid operations
- ✅ **Performance Optimized**: Efficient ArrayList-based transaction storage
- ✅ **Test Coverage**: Handles edge cases and error scenarios
- ✅ **No External Dependencies**: Uses only core Java libraries

## 🏗️ Architecture

### Core Components

- **`AccountService`**: Interface defining the banking contract
- **`Account`**: Main implementation with business logic
- **`Transaction`**: Data model for storing transaction history
- **`InteractiveBanking`**: Interactive terminal application for testing

### Design Principles

- **Single Responsibility**: Each class has one clear purpose
- **Interface Segregation**: Clean separation between contract and implementation  
- **Input Validation**: Comprehensive error handling for edge cases
- **Immutable Transactions**: Transaction records cannot be modified after creation

## 🚀 How to Run

### Prerequisites
- Java 8 or higher
- Command line terminal

### Compilation and Execution

```bash
# Compile all Java files
javac *.java

# Run the interactive banking application
java InteractiveBanking
```

### Available Commands

```
deposit [amount]    - Add money to account (e.g., deposit 1000)
withdraw [amount]   - Remove money from account (e.g., withdraw 500)
statement          - Display transaction history
balance            - Show current account balance
exit               - Close the application
```

## 💡 Usage Examples

```bash
Enter command: deposit 1000
✓ Deposited 1000. New balance: 1000

Enter command: deposit 2000  
✓ Deposited 2000. New balance: 3000

Enter command: withdraw 500
✓ Withdrew 500. New balance: 2500

Enter command: statement
--- Your Bank Statement ---
DATE | AMOUNT | BALANCE
28/06/2025 | -500 | 2500
28/06/2025 | 2000 | 3000
28/06/2025 | 1000 | 1000
--- End of Statement ---
```

## 🧪 Test Scenarios Covered

### Happy Path
- Normal deposits and withdrawals
- Balance inquiries
- Statement generation with proper formatting

### Edge Cases
- Negative amount validation
- Zero amount validation  
- Insufficient funds prevention
- Overdraft protection

### Error Handling
- Invalid input formats
- Boundary condition testing
- Exception propagation with clear messages