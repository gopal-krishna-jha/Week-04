
// Importing the required packages.
import java.util.*;

// Class to find frequency of elements in a list
class FrequencyCounter {
    // Method for counting frequency of elements in a list.
    public static Map<String, Integer> countFrequency(List<String> list) {
        Map<String, Integer> frequencyMap = new HashMap<>();
        // Counting frequency of elements
        for (String element : list) {

            // Storing the frequency of each element.
            frequencyMap.put(element, frequencyMap.getOrDefault(element, 0) + 1);
        }

        // Returning the frequency map.
        return frequencyMap;
    }
}

// Main class named FrequencyCounterMain to test frequency counting.
public class FrequencyCounterMain {
    public static void main(String[] args) {
        // Given Example list of strings.
        List<String> words = Arrays.asList("apple", "banana", "apple", "orange");

        // Counting the frequency of elements.
        Map<String, Integer> frequency = FrequencyCounter.countFrequency(words);

        // Displaying the frequency map.
        System.out.println("Frequency of elements: " + frequency);
    }
}
