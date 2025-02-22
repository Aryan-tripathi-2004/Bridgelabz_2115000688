import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class ExceptionHandler {
    int divide(int a, int b) {
        if (b == 0) throw new ArithmeticException("Cannot divide by zero");
        return a / b;
    }
}

public class ExceptionHandlerTest {
    ExceptionHandler handler = new ExceptionHandler();

    @Test
    void testDivideByZero() {
        assertThrows(ArithmeticException.class, () -> handler.divide(5, 0));
    }
}
