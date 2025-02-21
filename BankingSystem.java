import java.util.*;

class BankingSystem {

    // HashMap to store customer account numbers and their respective balances
    private static Map<Integer, Double> customerAccounts = new HashMap<>();

    // TreeMap to store customers sorted by balance in ascending order
    private static Map<Integer, Double> sortedByBalance = new TreeMap<>(Comparator.comparing(customerAccounts::get));

    // Queue to process withdrawal requests
    private static Queue<WithdrawalRequest> withdrawalQueue = new LinkedList<>();

    // Class to represent a withdrawal request (account number and amount)
    static class WithdrawalRequest {
        int accountNumber;
        double amount;

        WithdrawalRequest(int accountNumber, double amount) {
            this.accountNumber = accountNumber;
            this.amount = amount;
        }
    }

    // Add a new customer account
    public static void addCustomerAccount(int accountNumber, double balance) {
        customerAccounts.put(accountNumber, balance);
        sortedByBalance.put(accountNumber, balance);
    }

    // Deposit money to a customer's account
    public static void deposit(int accountNumber, double amount) {
        customerAccounts.put(accountNumber, customerAccounts.get(accountNumber) + amount);
        sortedByBalance.put(accountNumber, customerAccounts.get(accountNumber));
    }

    // Withdraw money from a customer's account (if enough balance)
    public static void withdraw(int accountNumber, double amount) {
        WithdrawalRequest request = new WithdrawalRequest(accountNumber, amount);
        withdrawalQueue.add(request);
    }

    // Process withdrawal requests from the queue
    public static void processWithdrawals() {
        while (!withdrawalQueue.isEmpty()) {
            WithdrawalRequest request = withdrawalQueue.poll();
            int accountNumber = request.accountNumber;
            double amount = request.amount;
            double currentBalance = customerAccounts.get(accountNumber);

            if (currentBalance >= amount) {
                // Process the withdrawal
                customerAccounts.put(accountNumber, currentBalance - amount);
                sortedByBalance.put(accountNumber, currentBalance - amount);
                System.out.println("Withdrawal of $" + amount + " processed for account: " + accountNumber);
            } else {
                System.out.println("Insufficient balance for account: " + accountNumber);
            }
        }
    }

    // Display all customer accounts
    public static void displayCustomerAccounts() {
        System.out.println("Customer Accounts (Unsorted): ");
        customerAccounts.forEach((accountNumber, balance) -> System.out.println("Account " + accountNumber + ": $" + balance));
    }

    // Display customers sorted by balance
    public static void displaySortedCustomersByBalance() {
        System.out.println("Customers Sorted by Balance: ");
        sortedByBalance.forEach((accountNumber, balance) -> System.out.println("Account " + accountNumber + ": $" + balance));
    }

    public static void main(String[] args) {
        // Adding customers
        addCustomerAccount(101, 500.0);
        addCustomerAccount(102, 1000.0);
        addCustomerAccount(103, 150.0);

        // Displaying customer accounts
        displayCustomerAccounts();
        displaySortedCustomersByBalance();

        // Making some deposit and withdrawal requests
        deposit(101, 200.0);
        withdraw(102, 500.0);
        withdraw(103, 200.0);  // This will fail due to insufficient balance

        // Process all withdrawal requests
        processWithdrawals();

        // Displaying customer accounts after transactions
        displayCustomerAccounts();
        displaySortedCustomersByBalance();
    }
}
