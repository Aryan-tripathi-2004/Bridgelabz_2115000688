import java.io.*;

class UpperToLower {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new FileReader("input.txt"));
             BufferedWriter bw = new BufferedWriter(new FileWriter("output.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                bw.write(line.toLowerCase());
                bw.newLine();
            }
            System.out.println("Converted to lowercase successfully.");
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}