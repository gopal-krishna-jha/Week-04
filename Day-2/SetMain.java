// Importing java util package.
import java.util.*;

// Class for computing union, intersection, and symmetric difference of two sets.
class SetOperations {
    // Method for computing the union of two sets.
    public static <T> Set<T> union(Set<T> set1, Set<T> set2) {
        // Creating a new set to store the union result.
        Set<T> result = new HashSet<>(set1);
        // Adding all elements from the second set to the result set.
        result.addAll(set2);
        return result;
    }

    // Method for computing the intersection of two sets.
    public static <T> Set<T> intersection(Set<T> set1, Set<T> set2) {
        // Creating a new set to store the intersection result
        Set<T> result = new HashSet<>(set1);
        // Retaining only the elements that are present in both sets.
        result.retainAll(set2);
        return result;
    }

    // Method for computing the symmetric difference of two sets.
    public static <T> Set<T> symmetricDifference(Set<T> set1, Set<T> set2) {
        // Creating a new set to store the symmetric difference result.
        Set<T> result = new HashSet<>(set1);
        // Adding all elements from set2.
        result.addAll(set2);
        // Creating a set containing the intersection of set1 and set2.
        Set<T> intersection = intersection(set1, set2);
        // Removing all elements that are in the intersection from the result set.
        result.removeAll(intersection);
        // Returning the symmetric difference set.
        return result;
    }
}

// Main class to test set operations
public class SetMain {
    public static void main(String[] args) {
        // Example sets with some common and unique elements
        Set<Integer> set1 = new HashSet<>(Arrays.asList(1, 2, 3));
        Set<Integer> set2 = new HashSet<>(Arrays.asList(3, 4, 5));

        // Computing the union of set1 and set2
        Set<Integer> unionSet = SetOperations.union(set1, set2);

        // Computing the intersection of set1 and set2
        Set<Integer> intersectionSet = SetOperations.intersection(set1, set2);

        // Computing the symmetric difference of set1 and set2
        Set<Integer> symmetricDifferenceSet = SetOperations.symmetricDifference(set1, set2);

        // Displaying the results
        System.out.println("Union: " + unionSet);
        System.out.println("Intersection: " + intersectionSet);
        System.out.println("Symmetric Difference: " + symmetricDifferenceSet); 
    }
}
