// Importing java classes.
import java.io.*;

public class FileReaderExample {
    public static void main(String[] args) {
        // Defining the file name to be read.
        String fileName = "data.txt";

        // Trying to open and read the file.
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            // Reading and print each line of the file.
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (FileNotFoundException e) {
            // Handling the case when the file is not found.
            System.out.println("File not found");
        } catch (IOException e) {
            // Handling other IO exceptions that might occur while reading the file.
            System.out.println("An error occurred while reading the file.");
        }
    }
}
