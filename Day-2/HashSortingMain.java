//Importing required packages.
import java.util.*;

// Class to convert a set to a sorted list
class HashSorting {
    // Method for converting a HashSet to a sorted list.
    public static List<Integer> convertToSortedList(Set<Integer> inputSet) {
        List<Integer> sortedList = new ArrayList<>(inputSet);
        // Sorting the list in ascending order
        Collections.sort(sortedList); 
        // Returning the sorted list.
        return sortedList;
    }
}

// Main class to test the set-to-list conversion
public class HashSortingMain {
    public static void main(String[] args) {
        // Creating a HashSet with some unordered numbers
        Set<Integer> numberSet = new HashSet<>(Arrays.asList(5, 3, 9, 1));

        // Converting the set to a sorted list
        List<Integer> sortedList = HashSorting.convertToSortedList(numberSet);

        // Displaying the sorted list
        System.out.println("Sorted List: " + sortedList); 
    }
}
