// Importing Java classes.
import java.util.*;

public class DivisionExample {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            // Prompting user for two numbers.
            System.out.print("Enter the numerator: ");
            int numerator = scanner.nextInt();


            System.out.print("Enter the denominator: ");
            int denominator = scanner.nextInt();

            // Performing division.
            int result = numerator / denominator;
            System.out.println("Result: " + result);

        } 
        // Catch Block.
        catch (ArithmeticException e) {
            // Handling division by zero.
            System.out.println("Error: Division by zero is not allowed.");
        } catch (InputMismatchException e) {
            // Handlinh non-numeric input.
            System.out.println("Error: Please enter valid numeric values.");
        } finally {
            // Closing the scanner to avoid resource leak.
            scanner.close();
        }
    }
}