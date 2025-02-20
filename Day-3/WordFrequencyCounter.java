
// Importing the required classes.
import java.io.*;
import java.util.*;

// creating a class named WordFrequrncyCounter.
public class WordFrequencyCounter {
    public static void main(String[] args) {
        // Defining the file path.
        String filePath = "input.txt";

        // Creating a map to store word frequencies.
        Map<String, Integer> wordCountMap = new HashMap<>();

        // Try-with-resources to ensure BufferedReader is closed properly
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;

            // Reading the file line by line.
            while ((line = reader.readLine()) != null) {
                // Spliting line into words using regex to handle punctuation.
                String[] words = line.toLowerCase().split("\\W+");
                
                for (String word : words) {
                    if (!word.isEmpty()) {
                        wordCountMap.put(word, wordCountMap.getOrDefault(word, 0) + 1);
                    }
                }
            }
        } catch (FileNotFoundException e) {
            System.err.println("Error: File not found - " + filePath);
            return;
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
            return;
        }

        // Sorting words by frequency in descending order.
        List<Map.Entry<String, Integer>> sortedWords = new ArrayList<>(wordCountMap.entrySet());
        sortedWords.sort((a, b) -> b.getValue().compareTo(a.getValue()));

        // Displaying the top 5 most frequently occurring words.
        System.out.println("Top 5 most frequent words:");
        for (int i = 0; i < Math.min(5, sortedWords.size()); i++) {
            Map.Entry<String, Integer> entry = sortedWords.get(i);
            
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}
