// Importing Java Classes
import java.util.*;

// Custom exception class for handling invalid age.
class InvalidAgeException extends Exception {
    // 
    public InvalidAgeException(String message) {

        super(message);
    }
}

public class AgeValidator {

    // Method to validate age.
    public static void validateAge(int age) throws InvalidAgeException {
        if (age < 18) {
            // Throwing custom exception if age is below 18.
            throw new InvalidAgeException("Age must be 18 or above");
        }
        // Printing success message if age is valid.
        System.out.println("Access granted!");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            // Taking input from user.
            System.out.print("Enter your age: ");
            int age = scanner.nextInt();

            // Calling method to validate age.
            validateAge(age);
        } catch (InvalidAgeException e) {
            // Handling custom exception and print error message.
            System.out.println(e.getMessage());
        } catch (Exception e) {
            // Handling unexpected exceptions such as non-numeric input.
            System.out.println("Invalid input. Please enter a valid number.");
        } finally {
            // Closing the scanner to prevent resource leaks.
            scanner.close();
        }
    }
}
