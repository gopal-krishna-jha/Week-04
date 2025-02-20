import java.io.*;
import java.util.*;

// Employee class implementing Serializable to allow object serialization
class Employee implements Serializable {
    private static final long serialVersionUID = 1L; 
    // Employee attributes
    private int id;
    private String name;
    private String department;
    private double salary;

    // Constructor to initialize employee details
    public Employee(int id, String name, String department, double salary) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    // Overriding toString() method for easy display of employee details

    public String toString() {
        return "Employee[ID=" + id + ", Name=" + name + ", Department=" + department + ", Salary=" + salary + "]";
    }
}

// Main class to demonstrate serialization and deserialization of Employee

public class EmployeeSerialization {
    private static final String FILE_NAME = "employees.dat"; // File to store serialized objects

    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee(101, "Gopal", "HR", 5000));
        employees.add(new Employee(102, "Mahi", "IT", 50000));

        // Serializing employee list to file.
        serializeEmployees(employees);

        // Deserializing employee list from file.
        List<Employee> retrievedEmployees = deserializeEmployees();

        // Displaying retrieved employees.
        System.out.println("Retrieved Employees:");
        for (Employee emp : retrievedEmployees) {
            System.out.println(emp);
        }
    }

    // Method to serialize employee list and write to a file.
    private static void serializeEmployees(List<Employee> employees) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            oos.writeObject(employees);
            System.out.println("Employees serialized successfully.");
        } catch (IOException e) {
            System.err.println("Error during serialization: " + e.getMessage());
        }
    }

    // Method to deserialize employee list from a file.
    @SuppressWarnings("unchecked")
    // Suppressing unchecked cast warning for type safety.
    private static List<Employee> deserializeEmployees() {
        
        List<Employee> employees = new ArrayList<>();
        // Try-with-resources to automatically close streams.
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
            employees = (List<Employee>) ois.readObject();
            System.out.println("Employees deserialized successfully.");
            // Catching exceptions during deserialization.
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Error during deserialization: " + e.getMessage());
        }
        // Returning the list of employees.
        return employees;
    }
}
