import java.util.LinkedList;
import java.util.Queue;

// Define a class QueueBasedStack to simulate stack behavior using two queues
class QueueBasedStack {
    // Declare two queues for stack operations
    Queue<Integer> primaryQueue;
    Queue<Integer> secondaryQueue;

    // Constructor to initialize the queues
    public QueueBasedStack() {
        this.primaryQueue = new LinkedList<>();
        this.secondaryQueue = new LinkedList<>();
    }

    // Method to push an element onto the stack
    public void pushElement(int value) {
        secondaryQueue.add(value);
        while (!primaryQueue.isEmpty()) {
            secondaryQueue.add(primaryQueue.poll());
        }
        Queue<Integer> temp = primaryQueue;
        primaryQueue = secondaryQueue;
        secondaryQueue = temp;
    }

    // Method to remove and return the top element of the stack
    public int popElement() {
        if (primaryQueue.isEmpty())
            throw new IllegalArgumentException("Stack is empty!");
        return primaryQueue.poll();
    }

    // Method to retrieve the top element without removing it
    public int peekElement() {
        if (primaryQueue.isEmpty())
            throw new IllegalArgumentException("Stack is Empty!");
        return primaryQueue.peek();
    }

    // Method to display stack contents
    public void displayStackContents() {
        System.out.println(primaryQueue);
    }
}

// Define a class StackDemo to test the QueueBasedStack functionality
public class StackDemo {
    public static void main(String[] args) {
        // Create an instance of QueueBasedStack
        QueueBasedStack stack = new QueueBasedStack();

        // Push elements onto the stack
        stack.pushElement(1);
        stack.pushElement(2);
        stack.pushElement(3);

        // Display the stack
        stack.displayStackContents();
        System.out.println("Top element is: " + stack.peekElement());
        System.out.println("Popped element is: " + stack.popElement());

        // Display the stack after popping an element
        stack.displayStackContents();
    }
}
