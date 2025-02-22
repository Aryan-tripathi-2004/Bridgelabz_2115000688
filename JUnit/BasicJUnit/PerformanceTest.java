import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import java.util.concurrent.TimeUnit;
import static org.junit.jupiter.api.Assertions.*;

public class PerformanceTest {

    public String longRunningTask() throws InterruptedException {
        TimeUnit.SECONDS.sleep(3);
        return "Task Completed";
    }

    @Test
    @Timeout(2)
    void testLongRunningTask() throws InterruptedException {
        assertEquals("Task Completed", longRunningTask());
    }
}
