import java.io.*;
class PipedStreamExample {
    public static void main(String[] args) {
        try {
            final PipedOutputStream pos = new PipedOutputStream();
            final PipedInputStream pis = new PipedInputStream(pos);

            Thread writerThread = new Thread(() -> {
                try {
                    pos.write("Hello from writer thread!".getBytes());
                    pos.close();
                } catch (IOException e) {
                    System.out.println("Error: " + e.getMessage());
                }
            });

            Thread readerThread = new Thread(() -> {
                try {
                    int data;
                    while ((data = pis.read()) != -1) {
                        System.out.print((char) data);
                    }
                    pis.close();
                } catch (IOException e) {
                    System.out.println("Error: " + e.getMessage());
                }
            });
            
            writerThread.start();
            readerThread.start();
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}