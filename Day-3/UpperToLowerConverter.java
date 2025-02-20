import java.io.*;

// This program reads a text file, converts all uppercase letters to lowercase, and writes it to another file.
public class UpperToLowerConverter {

    // Method to convert uppercase letters to lowercase while reading and writing a file
    public static void convertFileToLowerCase(String sourceFile, String destinationFile) {
        try (BufferedReader reader = new BufferedReader(new FileReader(sourceFile));
                BufferedWriter writer = new BufferedWriter(new FileWriter(destinationFile))) {

            String line;
            // Reading each line from the source file.
            while ((line = reader.readLine()) != null) {
                writer.write(line.toLowerCase()); // Converting to lowercase and write to the destination file.
                writer.newLine(); // Adding a newline character for proper formatting.
            }
            
            System.out.println("File conversion completed. Lowercase content written to " + destinationFile);

        } catch (IOException e) {
            
            System.err.println("Error processing file: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        String inputFilePath = "input_text.txt"; // Path to the source text file
        String outputFilePath = "output_text.txt"; // Path for the modified output file

        // Converting the file content to lowercase and write to a new file.
        convertFileToLowerCase(inputFilePath, outputFilePath);
    }
}
