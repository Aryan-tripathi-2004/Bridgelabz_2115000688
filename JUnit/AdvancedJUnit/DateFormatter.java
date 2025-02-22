import java.text.*;
import java.util.*;

public class DateFormatter {

    public String formatDate(String inputDate) {
        try {
            SimpleDateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd");
            SimpleDateFormat outputFormat = new SimpleDateFormat("dd-MM-yyyy");
            Date date = inputFormat.parse(inputDate);
            return outputFormat.format(date);
        } catch (ParseException e) {
            return null;
        }
    }

    public static class DateFormatterTest {

        private DateFormatter formatter;

        @BeforeEach
        void setUp() {
            formatter = new DateFormatter();
        }

        @Test
        void testValidDate() {
            String inputDate = "2025-02-22";
            String expectedDate = "22-02-2025";
            assertEquals(expectedDate, formatter.formatDate(inputDate));
        }

        @Test
        void testValidDateEdge() {
            String inputDate = "2000-01-01";
            String expectedDate = "01-01-2000";
            assertEquals(expectedDate, formatter.formatDate(inputDate));
        }

        @Test
        void testInvalidDateFormat() {
            String inputDate = "2025/02/22";
            assertNull(formatter.formatDate(inputDate));
        }

        @Test
        void testNullDate() {
            assertNull(formatter.formatDate(null));
        }

        @Test
        void testEmptyDate() {
            assertNull(formatter.formatDate(""));
        }

        @AfterEach
        void tearDown() {
            formatter = null;
        }
    }
}
