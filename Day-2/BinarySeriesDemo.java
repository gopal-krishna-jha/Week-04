// Importing required packages.
import java.util.*;

// Defining a class named  BinarySequenceGenerator to generate the first N binary numbers.
class BinarySequenceGenerator {
    // Static method to generate binary numbers up to a given count.
    public static void generateBinarySeries(int count) {
        // Initializing a queue to store binary numbers
        Queue<String> binaryQueue = new LinkedList<>();
        binaryQueue.add("1");

        // Iterating to generate binary numbers.
        for (int i = 0; i < count; i++) {
            // Polling the current binary number from the queue.
            String currentBinary = binaryQueue.poll();
            System.out.println(currentBinary + " ");
            binaryQueue.add(currentBinary + "0");
            binaryQueue.add(currentBinary + "1");
        }
    }
}

// Define a class named BinarySeriesDemo to demonstrate binary number generation
public class BinarySeriesDemo {
    public static void main(String[] args) {
        // Create a Scanner object to take user input
        Scanner userInput = new Scanner(System.in);

        // Taking input from the user.
        System.out.print("Enter the number of binary numbers to generate: ");
        int count = userInput.nextInt();
        userInput.close();

        // Calling the method to generate binary numbers.
        BinarySequenceGenerator.generateBinarySeries(count);
    }
}
