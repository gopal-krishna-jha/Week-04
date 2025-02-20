
// Importing required classes.
import java.time.LocalDate;
import java.util.*;

// Class representing an insurance policy
class InsurancePolicy {
    private String policyNumber;
    private String policyHolderName;
    private LocalDate expiryDate;

    // Constructor for initializing policy details.
    public InsurancePolicy(String policyNumber, String policyHolderName, LocalDate expiryDate) {
        this.policyNumber = policyNumber;
        this.policyHolderName = policyHolderName;
        this.expiryDate = expiryDate;
    }

    // Getter method for policy number.
    public String getPolicyNumber() {
        return policyNumber;
    }

    // Getter method for policy holder name.
    public String getPolicyHolderName() {
        return policyHolderName;
    }

    // Getter method for expiry date.
    public LocalDate getExpiryDate() {
        return expiryDate;
    }

    // Overriding toString() method to display policy details.
    public String toString() {
        return "Policy[" + policyNumber + ", Holder: " + policyHolderName + ", Expiry: " + expiryDate + "]";
    }
}

// Class to manage insurance policies
class InsurancePolicyManager {
    private Map<String, InsurancePolicy> policyMap = new HashMap<>(); // Stores policies by policy number
    private Map<String, InsurancePolicy> orderedPolicyMap = new LinkedHashMap<>(); // Maintains insertion order
    private Map<LocalDate, InsurancePolicy> sortedPolicyMap = new TreeMap<>(); // Sorts policies by expiry date

    // Method to add a new policy
    public void addPolicy(InsurancePolicy policy) {
        policyMap.put(policy.getPolicyNumber(), policy);
        orderedPolicyMap.put(policy.getPolicyNumber(), policy);
        sortedPolicyMap.put(policy.getExpiryDate(), policy);
    }

    // Method for retrieving a policy by its number.
    public InsurancePolicy getPolicyByNumber(String policyNumber) {
        return policyMap.get(policyNumber);
    }

    // Method for getting policies expiring within the next 'days' days.
    public List<InsurancePolicy> getPoliciesExpiringSoon(int days) {
        LocalDate threshold = LocalDate.now().plusDays(days);
        List<InsurancePolicy> expiringPolicies = new ArrayList<>();

        for (Map.Entry<LocalDate, InsurancePolicy> entry : sortedPolicyMap.entrySet()) {
            if (!entry.getKey().isAfter(threshold)) {
                expiringPolicies.add(entry.getValue());
            } else {
                break;
            }
        }
        return expiringPolicies;
    }

    // Method for retrieving policies by policyholder's name.
    public List<InsurancePolicy> getPoliciesByHolder(String policyHolder) {
        List<InsurancePolicy> policies = new ArrayList<>();
        for (InsurancePolicy policy : policyMap.values()) {
            if (policy.getPolicyHolderName().equalsIgnoreCase(policyHolder)) {
                policies.add(policy);
            }
        }
        return policies;
    }

    // Method for removing expired policies.
    public void removeExpiredPolicies() {
        LocalDate today = LocalDate.now();
        Iterator<Map.Entry<LocalDate, InsurancePolicy>> iterator = sortedPolicyMap.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<LocalDate, InsurancePolicy> entry = iterator.next();
            if (entry.getKey().isBefore(today)) {
                policyMap.remove(entry.getValue().getPolicyNumber());
                orderedPolicyMap.remove(entry.getValue().getPolicyNumber());
                iterator.remove();
            } else {
                break;
            }
        }
    }

    // Method for displaying all policies in insertion order.
    public void displayAllPolicies() {
        for (InsurancePolicy policy : orderedPolicyMap.values()) {
            System.out.println(policy);
        }
    }
}

// Main class for demonstrating the functionality of the Insurance Policy
// Management System
public class InsuranceSystem {
    public static void main(String[] args) {
        InsurancePolicyManager manager = new InsurancePolicyManager();

        // Adding sample policies to the manager.
        manager.addPolicy(new InsurancePolicy("P1001", "Ram", LocalDate.of(2025, 3, 15))); // Policies for Ram.
        manager.addPolicy(new InsurancePolicy("P1002", "Shyam", LocalDate.of(2024, 2, 28))); // Policies for Shyam.
        manager.addPolicy(new InsurancePolicy("P1003", "Radha", LocalDate.of(2024, 3, 5))); // Policies for Radha.

        // Displaying policies expiring within 30 days.
        System.out.println("Policies expiring within 30 days:");
        System.out.println(manager.getPoliciesExpiringSoon(30));

        // Displaying policies for a Ram.
        System.out.println("Policies for Ram:");
        System.out.println(manager.getPoliciesByHolder("Ram"));

        // Remove expired policies
        System.out.println("Removing expired policies...");
        manager.removeExpiredPolicies();

        // Display all remaining policies
        System.out.println("All Policies:");
        manager.displayAllPolicies();
    }
}
