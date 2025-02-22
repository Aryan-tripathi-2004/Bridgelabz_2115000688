import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;
import java.io.*;
import java.nio.file.*;

public class FileProcessor {

    public void writeToFile(String filename, String content) throws IOException {
        Files.write(Paths.get(filename), content.getBytes());
    }

    public String readFromFile(String filename) throws IOException {
        return new String(Files.readAllBytes(Paths.get(filename)));
    }

    public static class FileProcessorTest {

        private FileProcessor processor;
        private String filename = "testFile.txt";

        @BeforeEach
        void setUp() {
            processor = new FileProcessor();
        }

        @Test
        void testWriteAndReadContent() throws IOException {
            String content = "Hello, JUnit!";
            processor.writeToFile(filename, content);
            String readContent = processor.readFromFile(filename);
            assertEquals(content, readContent);
        }

        @Test
        void testFileExistsAfterWriting() throws IOException {
            String content = "File existence test";
            processor.writeToFile(filename, content);
            assertTrue(Files.exists(Paths.get(filename)));
        }

        @Test
        void testIOExceptionWhenFileDoesNotExist() {
            String invalidFilename = "nonExistentFile.txt";
            assertThrows(IOException.class, () -> processor.readFromFile(invalidFilename));
        }

        @AfterEach
        void tearDown() throws IOException {
            Files.deleteIfExists(Paths.get(filename));
        }
    }
}
