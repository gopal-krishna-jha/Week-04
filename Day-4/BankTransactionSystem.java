// Importing Java classes.
import java.util.*;

// Custom exception for insufficient balance.
class InsufficientBalanceException extends Exception {
    public InsufficientBalanceException(String message) {
        super(message);
    }
}

class BankAccount {
    private double balance;

    // Constructing to initialize balance.
    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }

    // Method for withdrawing money from the account.
    public void withdraw(double amount) throws InsufficientBalanceException, IllegalArgumentException {
        if (amount < 0) {
            throw new IllegalArgumentException("Invalid amount!");
        }
        if (amount > balance) {
            throw new InsufficientBalanceException("Insufficient balance!");
        }
        balance -= amount;
        System.out.println("Withdrawal successful, new balance: " + balance);
    }
}

public class BankTransactionSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BankAccount account = new BankAccount(5000); // Initial balance

        try {
            // Prompt user for withdrawal amount
            System.out.print("Enter withdrawal amount: ");
            double amount = scanner.nextDouble();

            // Attempt withdrawal
            account.withdraw(amount);
        } catch (InsufficientBalanceException | IllegalArgumentException e) {
            // Handle exceptions for insufficient balance and invalid amount
            System.out.println(e.getMessage());
        } finally {
            // Close scanner to prevent resource leaks
            scanner.close();
        }
    }
}
