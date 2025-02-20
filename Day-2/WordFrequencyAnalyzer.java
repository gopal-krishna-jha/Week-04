
import java.io.*;
import java.util.*;

// Define a class TextAnalyzer to read a file and count word occurrences
class TextAnalyzer {
    // Method to analyze word frequency in a given file
    public static void analyzeWordFrequency(String fileLocation) {
        // Create a HashMap to store word counts
        HashMap<String, Integer> wordCountMap = new HashMap<>();
        BufferedReader fileReader = null;

        // Try-catch block to handle file reading exceptions
        try {
            fileReader = new BufferedReader(new FileReader(fileLocation));
            String fileLine;

            // Read the file line by line
            while ((fileLine = fileReader.readLine()) != null) {
                // Convert text to lowercase and remove non-alphabetic characters
                String[] words = fileLine.toLowerCase().replaceAll("[^a-zA-Z ]", "").split("\\s+");

                for (String word : words) {
                    wordCountMap.put(word, wordCountMap.getOrDefault(word, 0) + 1);
                }
            }

            // Display the word frequency count
            System.out.printf("%-17s %s", "Word", "Count");
            for (Map.Entry<String, Integer> entry : wordCountMap.entrySet()) {
                System.out.printf("\n%-17s %d", entry.getKey(), entry.getValue());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

// Define a class WordFrequencyAnalyzer to execute the analysis
public class WordFrequencyAnalyzer {
    public static void main(String[] args) {
        // Define the file path containing the text
        String fileLocation = "sample.txt";

        // Call the method to analyze and print word frequencies
        TextAnalyzer.analyzeWordFrequency(fileLocation);
    }
}
