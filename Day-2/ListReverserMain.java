
// Importing required packages.
import java.util.*;

// Class to reverse a list without using built-in reverse methods.
class ListReverser {
    // Method for reverse an ArrayList.
    public static <T> void reverseArrayList(List<T> list) {
        int left = 0, right = list.size() - 1;
        while (left < right) {
            T temp = list.get(left);
            list.set(left, list.get(right));
            list.set(right, temp);
            left++;
            right--;
        }
    }

    // Method for reversing a LinkedList
    public static <T> void reverseLinkedList(LinkedList<T> list) {
        int left = 0, right = list.size() - 1;
        while (left < right) {
            T temp = list.get(left);
            list.set(left, list.get(right));
            list.set(right, temp);
            left++;
            right--;
        }
    }
}

// Main class named ListReverserMain to test List reversal.
public class ListReverserMain {
    public static void main(String[] args) {
        // Testing for the ArrayList reversal.
        List<Integer> arrayList = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
        System.out.println("Original ArrayList: " + arrayList);
        ListReverser.reverseArrayList(arrayList);
        System.out.println("Reversed ArrayList: " + arrayList);

        // Testing for the LinkedList reversal.
        LinkedList<Integer> linkedList = new LinkedList<>(Arrays.asList(1, 2, 3, 4, 5));
        System.out.println("Original LinkedList: " + linkedList);
        ListReverser.reverseLinkedList(linkedList);
        System.out.println("Reversed LinkedList: " + linkedList);
    }
}
