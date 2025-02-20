import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// Create an Employee class to define employee details
class Employee {
    private String name; // Employee's name
    private String department; // Employee's department

    // Constructor to initialize Employee object
    public Employee(String name, String department) {
        this.name = name;
        this.department = department;
    }

    // Getter method to retrieve employee name
    public String getName() {
        return name;
    }

    // Getter method to retrieve employee department
    public String getDepartment() {
        return department;
    }

    // Static method to group employees by department
    public static Map<String, List<Employee>> groupObjectByDepartment(List<Employee> employees) {
        Map<String, List<Employee>> employeesDepartment = new HashMap<>();

        // Iterate over the employee list and group them by department
        for (Employee employee : employees) {
            String department = employee.getDepartment();
            employeesDepartment.computeIfAbsent(department, k -> new ArrayList<>()).add(employee);
        }
        return employeesDepartment;
    }

    // Override toString method to return employee name when printed
    @Override
    public String toString() {
        return name;
    }
}

// Class to demonstrate grouping employees by department
public class GroupObjectsByProperty {
    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>(); // List to store Employee objects

        // Adding employees to the list
        employees.add(new Employee("Alice", "HR"));
        employees.add(new Employee("Bob", "IT"));
        employees.add(new Employee("Carol", "HR"));
       

        // Group employees by their department
        Map<String, List<Employee>> employeesDepartment = Employee.groupObjectByDepartment(employees);

        // Display grouped employees by department
        for (Map.Entry<String, List<Employee>> entry : employeesDepartment.entrySet()) {
            System.out.println(entry.getKey() + " = " + entry.getValue());
        }
    }
}
