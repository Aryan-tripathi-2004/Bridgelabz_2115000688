import java.util.*;

class InsurancePolicy implements Comparable<InsurancePolicy> {
    private String policyNumber;
    private String policyholderName;
    private Date expiryDate;
    private String coverageType;
    private double premiumAmount;

    public InsurancePolicy(String policyNumber, String policyholderName, Date expiryDate, String coverageType, double premiumAmount) {
        this.policyNumber = policyNumber;
        this.policyholderName = policyholderName;
        this.expiryDate = expiryDate;
        this.coverageType = coverageType;
        this.premiumAmount = premiumAmount;
    }

    public String getPolicyNumber() {
        return policyNumber;
    }

    public Date getExpiryDate() {
        return expiryDate;
    }

    public String getCoverageType() {
        return coverageType;
    }

    @Override
    public int compareTo(InsurancePolicy other) {
        return this.expiryDate.compareTo(other.expiryDate);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof InsurancePolicy)) return false;
        InsurancePolicy other = (InsurancePolicy) obj;
        return policyNumber.equals(other.policyNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(policyNumber);
    }

    @Override
    public String toString() {
        return "PolicyNumber: " + policyNumber + ", Holder: " + policyholderName + ", Expiry: " + expiryDate + ", Type: " + coverageType + ", Premium: $" + premiumAmount;
    }
}

public class InsurancePolicyManagement1 {
    private Set<InsurancePolicy> hashSetPolicies = new HashSet<>();
    private Set<InsurancePolicy> linkedHashSetPolicies = new LinkedHashSet<>();
    private Set<InsurancePolicy> treeSetPolicies = new TreeSet<>();

    public void addPolicy(InsurancePolicy policy) {
        hashSetPolicies.add(policy);
        linkedHashSetPolicies.add(policy);
        treeSetPolicies.add(policy);
    }

    public void displayAllPolicies() {
        System.out.println("\nAll Policies (HashSet - Unordered):");
        hashSetPolicies.forEach(System.out::println);

        System.out.println("\nAll Policies (LinkedHashSet - Insertion Order):");
        linkedHashSetPolicies.forEach(System.out::println);

        System.out.println("\nAll Policies (TreeSet - Sorted by Expiry Date):");
        treeSetPolicies.forEach(System.out::println);
    }

    public void displayExpiringSoon() {
        Date today = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(today);
        calendar.add(Calendar.DAY_OF_MONTH, 30);
        Date thresholdDate = calendar.getTime();

        System.out.println("\nPolicies Expiring in the Next 30 Days:");
        for (InsurancePolicy policy : treeSetPolicies) {
            if (policy.getExpiryDate().before(thresholdDate)) {
                System.out.println(policy);
            }
        }
    }

    public void displayByCoverageType(String coverageType) {
        System.out.println("\nPolicies with Coverage Type: " + coverageType);
        for (InsurancePolicy policy : hashSetPolicies) {
            if (policy.getCoverageType().equalsIgnoreCase(coverageType)) {
                System.out.println(policy);
            }
        }
    }

    public void findDuplicatePolicies() {
        Set<String> seenPolicyNumbers = new HashSet<>();
        Set<InsurancePolicy> duplicates = new HashSet<>();

        for (InsurancePolicy policy : hashSetPolicies) {
            if (!seenPolicyNumbers.add(policy.getPolicyNumber())) {
                duplicates.add(policy);
            }
        }

        System.out.println("\nDuplicate Policies:");
        duplicates.forEach(System.out::println);
    }

    public void performanceComparison() {
        int testSize = 100000;
        Set<InsurancePolicy> hashSet = new HashSet<>();
        Set<InsurancePolicy> linkedHashSet = new LinkedHashSet<>();
        Set<InsurancePolicy> treeSet = new TreeSet<>();
        long start, end;

        List<InsurancePolicy> policies = new ArrayList<>();
        for (int i = 0; i < testSize; i++) {
            policies.add(new InsurancePolicy("P" + i, "Holder" + i, new Date(), "Auto", 500 + i));
        }

        start = System.nanoTime();
        hashSet.addAll(policies);
        end = System.nanoTime();
        System.out.println("\nHashSet Add Time: " + (end - start) + " ns");

        start = System.nanoTime();
        linkedHashSet.addAll(policies);
        end = System.nanoTime();
        System.out.println("LinkedHashSet Add Time: " + (end - start) + " ns");

        start = System.nanoTime();
        treeSet.addAll(policies);
        end = System.nanoTime();
        System.out.println("TreeSet Add Time: " + (end - start) + " ns");

        start = System.nanoTime();
        hashSet.contains(policies.get(testSize / 2));
        end = System.nanoTime();
        System.out.println("HashSet Search Time: " + (end - start) + " ns");

        start = System.nanoTime();
        linkedHashSet.contains(policies.get(testSize / 2));
        end = System.nanoTime();
        System.out.println("LinkedHashSet Search Time: " + (end - start) + " ns");

        start = System.nanoTime();
        treeSet.contains(policies.get(testSize / 2));
        end = System.nanoTime();
        System.out.println("TreeSet Search Time: " + (end - start) + " ns");
    }

    public static void main(String[] args) {
        InsurancePolicyManagement1 system = new InsurancePolicyManagement1();
        
        Calendar cal = Calendar.getInstance();
        cal.set(2025, Calendar.MARCH, 10);
        Date date1 = cal.getTime();
        cal.set(2024, Calendar.FEBRUARY, 25);
        Date date2 = cal.getTime();
        cal.set(2024, Calendar.APRIL, 5);
        Date date3 = cal.getTime();

        system.addPolicy(new InsurancePolicy("P1001", "Alice Johnson", date1, "Health", 1200));
        system.addPolicy(new InsurancePolicy("P1002", "Bob Smith", date2, "Auto", 900));
        system.addPolicy(new InsurancePolicy("P1003", "Charlie Brown", date3, "Home", 1500));
        system.addPolicy(new InsurancePolicy("P1002", "Bob Smith", date2, "Auto", 900));

        system.displayAllPolicies();
        system.displayExpiringSoon();
        system.displayByCoverageType("Auto");
        system.findDuplicatePolicies();
        system.performanceComparison();
    }
}
