import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

class DatabaseConnection {
    boolean isConnected = false;

    void connect() {
        isConnected = true;
    }

    void disconnect() {
        isConnected = false;
    }

    boolean getConnectionStatus() {
        return isConnected;
    }
}

public class DatabaseConnectionTest {
    DatabaseConnection db;

    @BeforeEach
    void setUp() {
        db = new DatabaseConnection();
        db.connect();
    }

    @AfterEach
    void tearDown() {
        db.disconnect();
    }

    @Test
    void testConnectionEstablished() {
        assertTrue(db.getConnectionStatus());
    }

    @Test
    void testConnectionClosed() {
        db.disconnect();
        assertFalse(db.getConnectionStatus());
    }
}
