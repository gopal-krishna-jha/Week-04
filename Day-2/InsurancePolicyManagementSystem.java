import java.util.*;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

// Policy class representing an insurance policy
class Policy implements Comparable<Policy> {
    private String policyNumber;
    private String policyholderName;
    private LocalDate expiryDate;
    private String coverageType;
    private double premiumAmount;

    // Constructor to initialize policy details
    public Policy(String policyNumber, String policyholderName, LocalDate expiryDate, String coverageType,
            double premiumAmount) {
        this.policyNumber = policyNumber;
        this.policyholderName = policyholderName;
        this.expiryDate = expiryDate;
        this.coverageType = coverageType;
        this.premiumAmount = premiumAmount;
    }

    // Getters for policy attributes
    public String getPolicyNumber() {
        return policyNumber;
    }

    public LocalDate getExpiryDate() {
        return expiryDate;
    }

    public String getCoverageType() {
        return coverageType;
    }

    // Overriding equals and hashCode to ensure unique policies based on policy
    // number
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (!(obj instanceof Policy))
            return false;
        Policy other = (Policy) obj;
        return policyNumber.equals(other.policyNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(policyNumber);
    }

    // Compare policies based on expiry date for TreeSet sorting
    @Override
    public int compareTo(Policy other) {
        return this.expiryDate.compareTo(other.expiryDate);
    }

    // String representation of policy
    @Override
    public String toString() {
        return "Policy{" +
                "policyNumber='" + policyNumber + '\'' +
                ", policyholderName='" + policyholderName + '\'' +
                ", expiryDate=" + expiryDate +
                ", coverageType='" + coverageType + '\'' +
                ", premiumAmount=" + premiumAmount +
                '}';
    }
}

// Policy Management System handling different set types
public class InsurancePolicyManagementSystem {
    public static void main(String[] args) {
        // Creating different sets for policy storage
        Set<Policy> hashSet = new HashSet<>(); // Fast lookup
        Set<Policy> linkedHashSet = new LinkedHashSet<>(); // Maintains insertion order
        Set<Policy> treeSet = new TreeSet<>(); // Sorted by expiry date

        // Adding policies to the sets
        Policy p1 = new Policy("101", "Alice", LocalDate.now().plusDays(10), "Health", 5000);
        Policy p2 = new Policy("102", "Bob", LocalDate.now().plusDays(20), "Auto", 3000);
        Policy p3 = new Policy("103", "Charlie", LocalDate.now().plusDays(5), "Home", 7000);
        Policy p4 = new Policy("101", "Alice", LocalDate.now().plusDays(10), "Health", 5000); // Duplicate

        hashSet.add(p1);
        hashSet.add(p2);
        hashSet.add(p3);
        hashSet.add(p4);
        linkedHashSet.add(p1);
        linkedHashSet.add(p2);
        linkedHashSet.add(p3);
        linkedHashSet.add(p4);
        treeSet.add(p1);
        treeSet.add(p2);
        treeSet.add(p3);
        treeSet.add(p4);

        // Display all unique policies
        System.out.println("All Unique Policies (HashSet): " + hashSet);
        System.out.println("All Unique Policies (LinkedHashSet): " + linkedHashSet);
        System.out.println("All Unique Policies (TreeSet - Sorted by Expiry Date): " + treeSet);

        // Retrieve policies expiring within 30 days
        System.out.println("\nPolicies Expiring Soon (Next 30 Days):");
        for (Policy policy : treeSet) {
            if (ChronoUnit.DAYS.between(LocalDate.now(), policy.getExpiryDate()) <= 30) {
                System.out.println(policy);
            }
        }

        // Retrieve policies based on a specific coverage type
        String searchCoverage = "Health";
        System.out.println("\nPolicies with Coverage Type: " + searchCoverage);
        for (Policy policy : hashSet) {
            if (policy.getCoverageType().equalsIgnoreCase(searchCoverage)) {
                System.out.println(policy);
            }
        }

        // Identify duplicate policies based on policy number
        System.out.println("\nDuplicate Policies:");
        Set<String> uniquePolicyNumbers = new HashSet<>();
        for (Policy policy : hashSet) {
            if (!uniquePolicyNumbers.add(policy.getPolicyNumber())) {
                System.out.println(policy);
            }
        }
    }
}
