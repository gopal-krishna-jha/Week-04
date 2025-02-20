// Importing java classes.
import java.io.*;

public class FileReadExample {
    public static void main(String[] args) {
        String fileName = "info.txt";

        // Using try-with-resources to ensure automatic resource closing.
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            // Reading and printing the first line of the file.
            String firstLine = br.readLine();
            System.out.println("First line: " + firstLine);
        } catch (IOException e) {
            // Handling any IO exceptions that occur while reading the file.
            System.out.println("Error reading file");
        }
    }
}
