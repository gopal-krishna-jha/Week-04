// Importing the required Classes.
import java.io.*;

// This program stores student details (roll number, name, GPA) in a binary file and retrieves them later.
public class StudentDataHandler {

    // Method for writing student details to a binary file.
    public static void storeStudentData(String filePath) {
        try (DataOutputStream dataOutput = new DataOutputStream(new FileOutputStream(filePath))) {

            // Writing student details to the file
            dataOutput.writeInt(101); // Roll Number
            dataOutput.writeUTF("Gopal and Mahima"); // Name
            dataOutput.writeDouble(3.8); // GPA

            System.out.println("Student data successfully stored in " + filePath);
        } catch (IOException e) {
            System.err.println("Error storing student data: " + e.getMessage());
        }
    }

    // Method to read student details from a binary file.
    public static void retrieveStudentData(String filePath) {
        try (DataInputStream dataInput = new DataInputStream(new FileInputStream(filePath))) {

            // Reading student details from the file.
            int rollNumber = dataInput.readInt();
            String studentName = dataInput.readUTF();
            double studentGPA = dataInput.readDouble();

            // Displaying the retrieved student details.
            System.out.println("Retrieved Student Data:");
            System.out.println("Roll Number: " + rollNumber);
            System.out.println("Name: " + studentName);
            System.out.println("GPA: " + studentGPA);

        } catch (IOException e) {
            System.err.println("Error retrieving student data: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        // File path for storing student details.
        String studentDataFile = "student_data.bin"; 

        // Storing student details into a binary file.
        storeStudentData(studentDataFile);

        // Retrieving and displaying student details from the binary file.
        retrieveStudentData(studentDataFile);
    }
}
