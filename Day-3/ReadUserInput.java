// Importing required classes.
import java.io.*;


public class ReadUserInput {
    public static void main(String[] args) {
        // File to store user input data
        String fileName = "user_data.txt";

        // Try-with-resources to handle automatic resource management
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
                FileWriter writer = new FileWriter(fileName, true)) { // Append mode enabled

            // Taking input from the user.
            System.out.print("Enter your name: ");
            String name = reader.readLine();

            System.out.print("Enter your age: ");
            String age = reader.readLine();

            System.out.print("Enter your favorite programming language: ");
            String language = reader.readLine();

            // Formating and writing user data to file.
            writer.write("Name: " + name + "\n");
            writer.write("Age: " + age + "\n");
            writer.write("Favorite Programming Language: " + language + "\n");
            writer.write("-----------------------------------\n");

            // Notify user of successful data saving.
            System.out.println("User data saved successfully in " + fileName);

        } catch (IOException e) {
            System.out.println("An error occurred while reading input or writing to file: " + e.getMessage());
        }
    }
}
