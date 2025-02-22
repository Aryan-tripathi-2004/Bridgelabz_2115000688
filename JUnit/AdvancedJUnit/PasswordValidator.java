import java.util.regex.*;

public class PasswordValidator {

    public boolean isValidPassword(String password) {
        if (password == null || password.length() < 8) {
            return false;
        }
        Pattern pattern = Pattern.compile("^(?=.*[A-Z])(?=.*\\d).+$");
        Matcher matcher = pattern.matcher(password);
        return matcher.matches();
    }

    public static class PasswordValidatorTest {

        private PasswordValidator validator;

        @BeforeEach
        void setUp() {
            validator = new PasswordValidator();
        }

        @Test
        void testValidPassword() {
            assertTrue(validator.isValidPassword("Password1"));
        }

        @Test
        void testValidPasswordWithSpecialChars() {
            assertTrue(validator.isValidPassword("P@ssw0rd1"));
        }

        @Test
        void testInvalidPasswordTooShort() {
            assertFalse(validator.isValidPassword("Pwd1"));
        }

        @Test
        void testInvalidPasswordNoUppercase() {
            assertFalse(validator.isValidPassword("password1"));
        }

        @Test
        void testInvalidPasswordNoDigit() {
            assertFalse(validator.isValidPassword("Password"));
        }

        @Test
        void testInvalidPasswordNull() {
            assertFalse(validator.isValidPassword(null));
        }

        @AfterEach
        void tearDown() {
            validator = null;
        }
    }
}
