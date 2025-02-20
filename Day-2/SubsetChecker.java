import java.util.HashSet;
import java.util.Set;

// Class to check if one set is a subset of another
public class SubsetChecker {

    // Method to check if set1 is a subset of set2
    public static boolean isSubset(Set<Integer> set1, Set<Integer> set2) {
        return set2.containsAll(set1);
    }

    public static void main(String[] args) {
        // Define two sets
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();

        // Add elements to set1
        set1.add(2);
        set1.add(3);

        // Add elements to set2
        set2.add(1);
        set2.add(2);
        set2.add(3);
        set2.add(4);

        // Check if set1 is a subset of set2
        System.out.println("Is set1 a subset of set2? " + isSubset(set1, set2));
    }
}
