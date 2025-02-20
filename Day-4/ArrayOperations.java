// Importing Java classes.
import java.util.*;

public class ArrayOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            // Accept an integer array.
            Integer[] numbers = { 10, 20, 30, 40, 50 };

            // Taking input from the user.
            System.out.print("Enter index number: ");
            int index = scanner.nextInt();

            // Retrieving and printing value at the given index.
            System.out.println("Value at index " + index + ": " + numbers[index]);
        } catch (ArrayIndexOutOfBoundsException e) {
            // Handling case where index is out of bounds.
            System.out.println("Invalid index!");
        } catch (NullPointerException e) {
            // Handling case where array is null.
            System.out.println("Array is not initialized!");
        } finally {
            // Closing the scanner to prevent resource leaks.
            scanner.close();
        }
    }
}
