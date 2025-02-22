import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class StringUtils {
    String reverse(String str) {
        return new StringBuilder(str).reverse().toString();
    }

    boolean isPalindrome(String str) {
        return str.equalsIgnoreCase(reverse(str));
    }

    String toUpperCase(String str) {
        return str.toUpperCase();
    }
}

public class StringUtilsTest {
    StringUtils utils = new StringUtils();

    @Test
    void testReverse() {
        assertEquals("olleh", utils.reverse("hello"));
    }

    @Test
    void testIsPalindrome() {
        assertTrue(utils.isPalindrome("madam"));
        assertFalse(utils.isPalindrome("hello"));
    }

    @Test
    void testToUpperCase() {
        assertEquals("HELLO", utils.toUpperCase("hello"));
    }
}
