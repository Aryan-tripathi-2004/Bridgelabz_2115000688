import java.io.*;

public class BufferedStreams {
    public static void main(String[] args) {
        String sourceFile = "Input.txt";  
        String destBuffered = "Output.txt";
        String destUnbuffered = "Output2.txt";

        double timeBuffered = copyWithBufferedStream(sourceFile, destBuffered);
        double timeUnbuffered = copyWithUnbufferedStream(sourceFile, destUnbuffered);

        System.out.println("Buffered Stream Time: " + timeBuffered/1000000 + " ms");
        System.out.println("Unbuffered Stream Time: " + timeUnbuffered/1000000 + " ms");
    }

    private static long copyWithBufferedStream(String source, String destination) {
        long startTime = System.nanoTime();
        try (BufferedInputStream bis = new BufferedInputStream(new FileInputStream(source));
             BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(destination))) {
            byte[] buffer = new byte[4096];
            int bytesRead;
            while ((bytesRead = bis.read(buffer)) != -1) {
                bos.write(buffer, 0, bytesRead);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return System.nanoTime() - startTime;
    }

    private static long copyWithUnbufferedStream(String source, String destination) {
        long startTime = System.nanoTime();
        try (FileInputStream fis = new FileInputStream(source);
             FileOutputStream fos = new FileOutputStream(destination)) {
            int byteData;
            while ((byteData = fis.read()) != -1) {
                fos.write(byteData);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return System.nanoTime() - startTime;
    }
}
