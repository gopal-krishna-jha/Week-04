//Importing java util package.
import java.util.*;

// Defining a class QueueReverser to reverse elements in a queue
class QueueReverser {
    // Static method to reverse the order of elements in a queue.
    public static void reverse(Queue<Integer> dataQueue) {
        // Using a stack to assist in reversing the queue.
        Stack<Integer> helperStack = new Stack<>();
        // Moving all elements from the queue to the stack.
        while (!dataQueue.isEmpty()) {
            // Pushing elements from the queue to the stack.
            helperStack.push(dataQueue.remove());
        }
        // Moving all elements from the stack back to the queue.
        while (!helperStack.isEmpty()) {
            // Popping elements from the stack to the queue.
            dataQueue.add(helperStack.pop());
        }
    }
}

// Defining a class named ReverseQueueDemo to demonstrate queue reversal
 class ReverseQueueDemo {
    public static void main(String[] args) {
        // Initializing a queue to store integer values
        Queue<Integer> numbersQueue = new LinkedList<>();
        numbersQueue.add(10);
        numbersQueue.add(20);
        numbersQueue.add(30);

        // Calling the method to reverse the queue elements
        QueueReverser.reverse(numbersQueue);

        // Printing the reversed queue elements
        System.out.print("Reversed Queue: ");
        
        while (!numbersQueue.isEmpty()) {
            // Removing and printing elements from the queue.
            System.out.print(numbersQueue.remove() + " ");
        }
        // Printing a new line.
        System.out.println();
    }
}

// Defining a class BinaryGenerator to generate binary numbers
class BinaryGenerator {
    // Static method to generate the first N binary numbers
    public static void generate(int count) {
        // Initializing a queue to store binary numbers
        Queue<String> binaryQueue = new LinkedList<>();
        binaryQueue.add("1");

        // Generating and print binary numbers
        for (int i = 0; i < count; i++) {
            String currentBinary = binaryQueue.poll();
            System.out.print(currentBinary + " ");
            binaryQueue.add(currentBinary + "0");
            binaryQueue.add(currentBinary + "1");
        }
        System.out.println();
    }
}

// Defining a class BinaryGeneratorDemo to test binary number generation.
public class BinaryGeneratorDemo {
    public static void main(String[] args) {
        // Creating a Scanner object to take user input.
        Scanner scanner = new Scanner(System.in);

        // Prompt user for input
        System.out.print("Enter the number of binary numbers to generate: ");
        int count = scanner.nextInt();
        scanner.close();

        // Calling the method to generate binary numbers
        BinaryGenerator.generate(count);
    }
}