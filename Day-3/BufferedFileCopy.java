
//Importing the required classes.
import java.io.*;

// This program demonstrates efficient file copying using Buffered Streams.
// It also compares performance with unbuffered streams.
public class BufferedFileCopy {
    
    // Buffer size for reading and writing (4 KB)
    private static final int BUFFER_SIZE = 4096;
    
    public static void main(String[] args) {
        String sourceFile = "source.txt";  // Source file path
        String destinationBuffered = "destination_buffered.txt";  // Destination file for buffered copy
        String destinationUnbuffered = "destination_unbuffered.txt";  // Destination file for unbuffered copy
        
        // Measuring and comparing execution times.
        long bufferedTime = copyFileWithBuffer(sourceFile, destinationBuffered);
        long unbufferedTime = copyFileWithoutBuffer(sourceFile, destinationUnbuffered);
        
        // Displayings execution time results.
        System.out.println("Buffered Stream Copy Time: " + bufferedTime + " nanoseconds");
        System.out.println("Unbuffered Stream Copy Time: " + unbufferedTime + " nanoseconds");
    }
    
    // Method for copying a file using Buffered Streams.
    private static long copyFileWithBuffer(String source, String destination) {
        long startTime = System.nanoTime(); // Start timing
        
        // Try-with-resources to automatically close streams.
        try (BufferedInputStream inputStream = new BufferedInputStream(new FileInputStream(source));
             BufferedOutputStream outputStream = new BufferedOutputStream(new FileOutputStream(destination))) {
            
            byte[] buffer = new byte[BUFFER_SIZE]; // Buffer for reading data.
            int bytesRead;
            
            // Read from source and write to destination in chunks.
            while ((bytesRead = inputStream.read(buffer)) != -1) {
                outputStream.write(buffer, 0, bytesRead);
            }
            
        } catch (IOException e) {
            System.err.println("Error during buffered file copy: " + e.getMessage());
        }
        // Return elapsed time.
        return System.nanoTime() - startTime; 
    }
    
    // Method for copying a file without using Buffered Streams.
    private static long copyFileWithoutBuffer(String source, String destination) {
        long startTime = System.nanoTime(); // Start timing
        
        // Try-with-resources to automatically close streams
        try (FileInputStream inputStream = new FileInputStream(source);
             FileOutputStream outputStream = new FileOutputStream(destination)) {
            
            int data;
            
            // Read and write byte by byte.
            while ((data = inputStream.read()) != -1) {
                outputStream.write(data);
            }
            
        } catch (IOException e) {
            
            System.err.println("Error during unbuffered file copy: " + e.getMessage());
        }
        // Returning elapsed time.
        return System.nanoTime() - startTime; 
    }
}
