import java.io.*;
class DataStreamExample {
    public static void main(String[] args) {
        try (DataOutputStream dos = new DataOutputStream(new FileOutputStream("students.dat"))) {
            dos.writeInt(1);
            dos.writeUTF("John Doe");
            dos.writeDouble(3.9);
            System.out.println("Student data saved.");
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
        try (DataInputStream dis = new DataInputStream(new FileInputStream("students.dat"))) {
            int roll = dis.readInt();
            String name = dis.readUTF();
            double gpa = dis.readDouble();
            System.out.println("Student: " + roll + ", " + name + ", GPA: " + gpa);
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}