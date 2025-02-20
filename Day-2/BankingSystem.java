
// Importing required packages.
import java.util.*;

class BankSystem {
    // Storing the account balances.
    private Map<Integer, Double> accounts = new HashMap<>();
    // Sorting the accounts by balance.
    private TreeMap<Double, Integer> sortedAccounts = new TreeMap<>();
    // Queue for withdrawal requests
    private Queue<Integer> withdrawalQueue = new LinkedList<>();

    // Method for creating an account.
    public void createAccount(int accountNumber, double balance) {
        accounts.put(accountNumber, balance);
        sortedAccounts.put(balance, accountNumber);
    }

    // Method for request the withdrawal.
    public void requestWithdrawal(int accountNumber) {
        if (accounts.containsKey(accountNumber)) {
            withdrawalQueue.add(accountNumber);
        } else {
            System.out.println("Account not found: " + accountNumber);
        }
    }

    // Method for process withdrawals.
    public void processWithdrawals() {
        while (!withdrawalQueue.isEmpty()) {
            int accountNumber = withdrawalQueue.poll();
            System.out.println("Processing withdrawal for account: " + accountNumber);
        }
    }

    // Method for displaying accounts sorted by balance.
    public void displayAccountsSorted() {
        System.out.println("Accounts sorted by balance:");

        // Displaying the accounts sorted by balance.
        for (var entry : sortedAccounts.entrySet()) {
            System.out.println("Account: " + entry.getValue() + " = " + entry.getKey());
        }
    }
}

// Main class to test Banking System
public class BankingSystem {
    public static void main(String[] args) {
        // Testing the Banking System.
        BankSystem BankSystem = new BankSystem();
         // Creating account with 5000 balance
        BankSystem.createAccount(101, 5000);
        // Creating account with 2000 balance
        BankSystem.createAccount(102, 2000); 
        // Creating account with 7000 balance
        BankSystem.createAccount(103, 7000); 
        // Requesting withdrawal for account 102
        BankSystem.requestWithdrawal(102); 
        // Processing all withdrawal requests
        BankSystem.processWithdrawals(); 
        // Display accounts sorted by balance
        BankSystem.displayAccountsSorted(); 
    }
}
