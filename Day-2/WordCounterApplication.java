import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;

// Define a class FileWordCounter to read a file and count occurrences of words
class FileWordCounter {
    // Method to count word frequency in the given file
    public static void countWordsInFile(String filePath) {
        // Create a HashMap to store word occurrences
        HashMap<String, Integer> wordFrequencyMap = new HashMap<>();
        BufferedReader bufferedReader = null;

        // Try-catch block to handle file reading exceptions
        try {
            bufferedReader = new BufferedReader(new FileReader(filePath));
            String line;

            // Read each line from the file
            while ((line = bufferedReader.readLine()) != null) {
                // Convert text to lowercase and remove non-alphabetic characters
                String[] words = line.toLowerCase().replaceAll("[^a-zA-Z ]", "").split("\\s+");

                for (String word : words) {
                    wordFrequencyMap.put(word, wordFrequencyMap.getOrDefault(word, 0) + 1);
                }
            }

            // Display the word frequency count
            System.out.printf("%-17s %s", "Word", "Frequency");
            for (Map.Entry<String, Integer> entry : wordFrequencyMap.entrySet()) {
                System.out.printf("\n%-17s %d", entry.getKey(), entry.getValue());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

// Define a class WordCounterApplication to execute the file word count
// operation
public class WordCounterApplication {
    public static void main(String[] args) {
        // Specify the file path containing the text
        String filePath = "examplefile.txt";

        // Call the method to count and print word frequencies
        FileWordCounter.countWordsInFile(filePath);
    }
}
