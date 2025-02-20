// Importing necessary packages.
import java.io.*;

// This program converts an image file into a byte array and then reconstructs it back into another image file.
public class ImageByteArrayConverter {

    // Method for reading an image file and convert it into a byte array.
    public static byte[] convertImageToByteArray(String imagePath) {
        // Try-with-resources to automatically close streams.
        try (FileInputStream fileInput = new FileInputStream(imagePath);
                // Using ByteArrayOutputStream to store the image data.
                ByteArrayOutputStream byteStream = new ByteArrayOutputStream()) {
               
            byte[] buffer = new byte[4096]; 
            int bytesRead;
            
            while ((bytesRead = fileInput.read(buffer)) != -1) {
                byteStream.write(buffer, 0, bytesRead);
            }
            // Return the byte array representation of the image
            return byteStream.toByteArray(); 

        } catch (IOException e) {
            System.err.println("Error reading image file: " + e.getMessage());
            return null;
        }
    }

    // Method for writing a byte array back into an image file.
    public static void writeByteArrayToImage(byte[] imageBytes, String outputPath) {
        // Try-with-resources to automatically close streams.
        try (ByteArrayInputStream byteInput = new ByteArrayInputStream(imageBytes);
                FileOutputStream fileOutput = new FileOutputStream(outputPath)) {

            byte[] buffer = new byte[4096]; 
            int bytesRead;

            while ((bytesRead = byteInput.read(buffer)) != -1) {
                // Write the byte array data to the output image file.
                fileOutput.write(buffer, 0, bytesRead);
            }

            System.out.println("Image successfully written to " + outputPath);

        } catch (IOException e) {
            // Handle any errors that may occur during writing the image file.
            System.err.println("Error writing image file: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        String sourceImagePath = "source_image.jpg"; // Source image file path
        String outputImagePath = "output_image.jpg"; // Destination image file path

        // Converting the image to a byte array
        byte[] imageData = convertImageToByteArray(sourceImagePath);

        // Ensuring the conversion was successful before proceeding
        if (imageData != null) {
            // Writing the byte array back to a new image file
            writeByteArrayToImage(imageData, outputImagePath);
        }
    }
}
