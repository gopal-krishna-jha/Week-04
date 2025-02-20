
//Importing required packages.
import java.util.*;

// Class named LinkedListFinder to find the Nth element from the end in a linked list.
class LinkedListFinder {
    // Method to find the Nth element from the end.
    public static <T> T findNthFromEnd(LinkedList<T> list, int n) {
        Iterator<T> first = list.iterator();
        Iterator<T> second = list.iterator();

        // Moving the first iterator N steps ahead.
        for (int i = 0; i < n; i++) {
            // Handling the case when N is larger than the list size.
            if (!first.hasNext()) {
                throw new IllegalArgumentException("N is larger than the list size");
            }
            // Moving the first iterator N steps ahead.
            first.next();
        }

        // Moving both iterators until first reaches the end.
        while (first.hasNext()) {
            // Moving both iterators.
            first.next();
            second.next();
        }
        // Returning the Nth element from the end.
        return second.next(); 
    }
}

// Main named LinkedListFinderMain class to test finding Nth element from end
public class LinkedListFinderMain {
    public static void main(String[] args) {
        // Given example linked list in the question.
        LinkedList<String> list = new LinkedList<>(Arrays.asList("A", "B", "C", "D", "E"));
        int n = 2;

        // Finding the Nth element from the end.
        String result = LinkedListFinder.findNthFromEnd(list, n);

        // Displaying the result.
        System.out.println("The " + n + "th element from the end is: " + result);
    }
}
