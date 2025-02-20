// Importing the required packages.
import java.util.*;

// Class to remove duplicates while preserving the original order.
class DuplicateRemover {
    // Method for removing duplicates from a list while maintaining the order.
    public static <T> List<T> removeDuplicates(List<T> list) {
        Set<T> seen = new HashSet<>();
        List<T> result = new ArrayList<>();

        // Removing duplicates while preserving order
        for (T element : list) {
            if (seen.add(element)) {
                 // Only add if not already seen
                result.add(element);
            }
        }
        // Returning the list without duplicates.
        return result;
    }
}

// Main class named DuplicateRemover to test duplicate removal
public class DuplicateRemoverMain {
    public static void main(String[] args) {
        // Given example list with duplicates in the question.
        List<Integer> numbers = Arrays.asList(3, 1, 2, 2, 3, 4);

        // Displaying the original list.
        System.out.println("Original List: " + numbers);

        // Removing duplicates while preserving order.
        List<Integer> uniqueNumbers = DuplicateRemover.removeDuplicates(numbers);

        // Displaying list after removing duplicates.
        System.out.println("List after removing duplicates: " + uniqueNumbers);
    }
}
