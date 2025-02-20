// Importing required classes.
import java.io.*;


public class LargeFileReader {
    public static void main(String[] args) {
        // Define the file path.
        String filePath = "large_log.txt";

        // Try-with-resources to ensure BufferedReader is closed properly.
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;

            // Reading the file line by line.
            while ((line = reader.readLine()) != null) {
                // Checking if the line contains the word "error".
                if (line.toLowerCase().contains("error")) {
                    System.out.println(line);
                }
            }
            
        } catch (FileNotFoundException e) {
            System.err.println("Error: File not found - " + filePath);
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
    }
}
