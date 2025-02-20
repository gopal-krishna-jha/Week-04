
public class InterestCalculator {

    // Method for calculating interest.
    public static double calculateInterest(double amount, double rate, int years) throws IllegalArgumentException {
        if (amount < 0 || rate < 0) {
            // Throwing an exception if amount or rate is negative.
            throw new IllegalArgumentException("Invalid input: Amount and rate must be positive");
        }
        // Calculating and returning interest.
        return amount * rate * years / 100;
    }

    public static void main(String[] args) {
        try {
            // Testing with valid values.
            double interest = calculateInterest(1000, 5, 2);
            System.out.println("Calculated Interest: " + interest);
        } catch (IllegalArgumentException e) {
            // Handling exception and display error message.
            System.out.println(e.getMessage());
        }
    }
}
