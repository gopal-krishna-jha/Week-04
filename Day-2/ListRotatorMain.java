//Importing the required packages.
import java.util.*;

// Class for rotating elements in a list.
class ListRotator {
    // Method for rotating a list by a given number of positions.
    public static <T> void rotateList(List<T> list, int positions) {
        int size = list.size(); 
        // Handling rotations greater than list size.
        positions = positions % size;
        // Rotating left by given positions.
        Collections.rotate(list, -positions); 
    }
}

// Main class named ListRotatorMain to testing the list implementation.
public class ListRotatorMain {
    public static void main(String[] args) {
        // Given example list of integers
        List<Integer> numbers = new ArrayList<>(Arrays.asList(10, 20, 30, 40, 50));
        int rotateBy = 2;

        // Displaying the original list.
        System.out.println("Original List: " + numbers);

        // Rotating the list.
        ListRotator.rotateList(numbers, rotateBy);

        // Displaying the rotated list.
        System.out.println("Rotated List: " + numbers);
    }
}
