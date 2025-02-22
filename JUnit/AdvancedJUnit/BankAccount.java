import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

public class BankAccount {

    private double balance;

    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
        }
    }

    public boolean withdraw(double amount) {
        if (amount <= balance && amount > 0) {
            balance -= amount;
            return true;
        }
        return false;
    }

    public double getBalance() {
        return balance;
    }

    public static class BankAccountTest {

        private BankAccount account;

        @BeforeEach
        void setUp() {
            account = new BankAccount(1000.0);
        }

        @Test
        void testDeposit() {
            account.deposit(500.0);
            assertEquals(1500.0, account.getBalance());
        }

        @Test
        void testWithdrawSuccessful() {
            assertTrue(account.withdraw(200.0));
            assertEquals(800.0, account.getBalance());
        }

        @Test
        void testWithdrawInsufficientFunds() {
            assertFalse(account.withdraw(1500.0));
            assertEquals(1000.0, account.getBalance());
        }

        @Test
        void testWithdrawNegativeAmount() {
            assertFalse(account.withdraw(-100.0));
            assertEquals(1000.0, account.getBalance());
        }

        @Test
        void testDepositNegativeAmount() {
            account.deposit(-500.0);
            assertEquals(1000.0, account.getBalance());
        }

        @AfterEach
        void tearDown() {
            account = null;
        }
    }
}
