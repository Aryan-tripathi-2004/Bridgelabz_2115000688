import java.util.*;
import java.text.*;

class InsurancePolicy {
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

    public String getPolicyholderName() {
        return policyholderName;
    }

    public Date getExpiryDate() {
        return expiryDate;
    }

    public String getCoverageType() {
        return coverageType;
    }

    public double getPremiumAmount() {
        return premiumAmount;
    }

    @Override
    public String toString() {
        return "PolicyNumber: " + policyNumber + ", Policyholder: " + policyholderName + ", ExpiryDate: " + expiryDate + ", Coverage: " + coverageType + ", Premium: " + premiumAmount;
    }
}

public class InsurancePolicyManagementSystem2 {

    private static Map<String, InsurancePolicy> policyMap = new HashMap<>();
    private static Map<String, InsurancePolicy> policyLinkedMap = new LinkedHashMap<>();
    private static Map<String, InsurancePolicy> policyTreeMap = new TreeMap<>(Comparator.comparing((String key) -> {
        try {
            return new SimpleDateFormat("yyyy-MM-dd").parse(policyMap.get(key).getExpiryDate().toString());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }));

    public static void addPolicy(InsurancePolicy policy) {
        policyMap.put(policy.getPolicyNumber(), policy);
        policyLinkedMap.put(policy.getPolicyNumber(), policy);
        policyTreeMap.put(policy.getPolicyNumber(), policy);
    }

    public static InsurancePolicy getPolicyByNumber(String policyNumber) {
        return policyMap.get(policyNumber);
    }

    public static List<InsurancePolicy> getPoliciesExpiringSoon() {
        List<InsurancePolicy> expiringPolicies = new ArrayList<>();
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_YEAR, 30);
        Date thresholdDate = calendar.getTime();
        
        for (InsurancePolicy policy : policyMap.values()) {
            if (policy.getExpiryDate().before(thresholdDate)) {
                expiringPolicies.add(policy);
            }
        }

        return expiringPolicies;
    }

    public static List<InsurancePolicy> getPoliciesByPolicyholder(String policyholderName) {
        List<InsurancePolicy> policies = new ArrayList<>();
        for (InsurancePolicy policy : policyMap.values()) {
            if (policy.getPolicyholderName().equalsIgnoreCase(policyholderName)) {
                policies.add(policy);
            }
        }
        return policies;
    }

    public static void removeExpiredPolicies() {
        Date currentDate = new Date();
        policyMap.values().removeIf(policy -> policy.getExpiryDate().before(currentDate));
        policyLinkedMap.values().removeIf(policy -> policy.getExpiryDate().before(currentDate));
        policyTreeMap.values().removeIf(policy -> policy.getExpiryDate().before(currentDate));
    }

    public static void main(String[] args) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        // Add sample policies
        addPolicy(new InsurancePolicy("P001", "Alice", sdf.parse("2025-05-10"), "Health", 200.50));
        addPolicy(new InsurancePolicy("P002", "Bob", sdf.parse("2025-02-25"), "Auto", 150.75));
        addPolicy(new InsurancePolicy("P003", "Alice", sdf.parse("2025-03-15"), "Home", 300.25));
        addPolicy(new InsurancePolicy("P004", "Charlie", sdf.parse("2025-01-10"), "Health", 250.00));

        // Retrieve policy by number
        System.out.println("Policy P001: " + getPolicyByNumber("P001"));

        // List policies expiring in the next 30 days
        System.out.println("Policies Expiring Soon: " + getPoliciesExpiringSoon());

        // List policies for a specific policyholder
        System.out.println("Policies for Alice: " + getPoliciesByPolicyholder("Alice"));

        // Remove expired policies
        removeExpiredPolicies();
        System.out.println("Remaining Policies after removing expired ones: ");
        policyMap.values().forEach(System.out::println);
    }
}
