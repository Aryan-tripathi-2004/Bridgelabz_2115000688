import java.util.regex.*;

public class UserRegistration {

    public void registerUser(String username, String email, String password) {
        if (username == null || username.isEmpty()) {
            throw new IllegalArgumentException("Username cannot be empty");
        }
        if (email == null || !isValidEmail(email)) {
            throw new IllegalArgumentException("Invalid email format");
        }
        if (password == null || password.length() < 8) {
            throw new IllegalArgumentException("Password must be at least 8 characters long");
        }
    }

    private boolean isValidEmail(String email) {
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
        Pattern pattern = Pattern.compile(emailRegex);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    public static class UserRegistrationTest {

        private UserRegistration registration;

        @BeforeEach
        void setUp() {
            registration = new UserRegistration();
        }

        @Test
        void testValidUserRegistration() {
            assertDoesNotThrow(() -> registration.registerUser("user123", "user@example.com", "password123"));
        }

        @Test
        void testInvalidUsername() {
            assertThrows(IllegalArgumentException.class, () -> registration.registerUser("", "user@example.com", "password123"));
        }

        @Test
        void testInvalidEmail() {
            assertThrows(IllegalArgumentException.class, () -> registration.registerUser("user123", "invalid-email", "password123"));
        }

        @Test
        void testShortPassword() {
            assertThrows(IllegalArgumentException.class, () -> registration.registerUser("user123", "user@example.com", "short"));
        }

        @Test
        void testNullEmail() {
            assertThrows(IllegalArgumentException.class, () -> registration.registerUser("user123", null, "password123"));
        }

        @Test
        void testNullPassword() {
            assertThrows(IllegalArgumentException.class, () -> registration.registerUser("user123", "user@example.com", null));
        }

        @AfterEach
        void tearDown() {
            registration = null;
        }
    }
}
