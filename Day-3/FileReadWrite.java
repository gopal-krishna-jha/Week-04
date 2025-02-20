import java.io.*;

public class FileReadWrite {
    public static void main(String[] args) {
        // Define the source and destination file paths
        String sourceFilePath = "source.txt";
        String destinationFilePath = "destination.txt";

        // Call the method to perform file copy operation
        copyFile(sourceFilePath, destinationFilePath);
    }

    
     // Reads from the source file and writes to the destination file.
      //Uses FileInputStream and FileOutputStream for file handling.
    
    public static void copyFile(String sourceFile, String destinationFile) {
        FileInputStream fis = null;
        FileOutputStream fos = null;

        try {
            // Open input stream for reading the source file
            fis = new FileInputStream(sourceFile);
            // Open output stream for writing to the destination file
            fos = new FileOutputStream(destinationFile);

            int byteData;
            // Read data byte by byte and write it to the new file
            while ((byteData = fis.read()) != -1) {
                fos.write(byteData);
            }
            System.out.println("File copied successfully!");
        } catch (FileNotFoundException e) {
            // Handle the case where the source file is missing
            System.err.println("Error: Source file not found.");
        } catch (IOException e) {
            // Handle IO errors during read/write operations
            System.err.println("Error: Unable to read or write the file.");
        } finally {
            try {
                // Close the input stream if it was opened
                if (fis != null) fis.close();
                // Close the output stream if it was opened
                if (fos != null) fos.close();
            } catch (IOException e) {
                System.err.println("Error: Unable to close file streams.");
            }
        }
    }
}
