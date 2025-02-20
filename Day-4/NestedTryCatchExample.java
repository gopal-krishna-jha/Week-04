//Importing required class.
import java.util.*;

public class NestedTryCatchExample {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // Sample array of integer type.
        int[] numbers = { 10, 20, 30, 40, 50 }; 

        try {
            // Prompting user for index input.
            System.out.print("Enter array index: ");
            int index = scanner.nextInt();

            try {
                // Trying to access the element at the given index.
                int element = numbers[index];

                // Prompting user for divisor input.
                System.out.print("Enter divisor: ");
                int divisor = scanner.nextInt();

                // Trying to perform division.
                int result = element / divisor;
                System.out.println("Result: " + result);
            } catch (ArithmeticException e) {
                // Handling division by zero.
                System.out.println("Cannot divide by zero!");
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            // Handlinf invalid array index access.
            System.out.println("Invalid array index!");
        } finally {
            // Closing scanner to prevent resource leaks.
            scanner.close();
        }
    }
}
