
// Importing java util package.
import java.util.*;

// Class for checking if two sets are equal.
class SetComparator {
    // Method for comparing two sets and determine if they contain the same elements.
    public static <T> boolean areSetsEqual(Set<T> set1, Set<T> set2) {
        // Comparing using equals method.
        return set1.equals(set2); 
    }
}

// Main class named to test set equality.
public class SetComparatorMain {
    public static void main(String[] args) {
      
        Set<Integer> set1 = new HashSet<>(Arrays.asList(1, 2, 3));
        Set<Integer> set2 = new HashSet<>(Arrays.asList(3, 2, 1));
        
        // Checking if sets are equal.
        boolean result = SetComparator.areSetsEqual(set1, set2);
        
        // Displaying the result
        System.out.println("Are the sets equal? " + result);
    }
}
