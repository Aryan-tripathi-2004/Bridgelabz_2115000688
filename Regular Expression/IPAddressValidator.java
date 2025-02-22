import java.util.Scanner;

public class IPAddressValidator {
    public static boolean isValidIP(String ip) {
        return ip.matches("\\b(25[0-5]|2[0-4]\\d|1\\d{2}|[1-9]?\\d)\\.(25[0-5]|2[0-4]\\d|1\\d{2}|[1-9]?\\d)\\.(25[0-5]|2[0-4]\\d|1\\d{2}|[1-9]?\\d)\\.(25[0-5]|2[0-4]\\d|1\\d{2}|[1-9]?\\d)\\b");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter an IP address to validate: ");
        String ip = scanner.nextLine();

        if (isValidIP(ip)) {
            System.out.println(" Valid IP address!");
        } else {
            System.out.println(" Invalid IP address! It must be in the format xxx.xxx.xxx.xxx (0-255).");
        }
        scanner.close();
    }
}
