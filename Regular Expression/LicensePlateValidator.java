import java.util.Scanner;

public class LicensePlateValidator {
    public static boolean isValidLicensePlate(String plate) {
        return plate.matches("^[A-Z]{2}\\d{4}$");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a license plate number (format: XX1234): ");
        String plate = scanner.nextLine();

        if (isValidLicensePlate(plate)) {
            System.out.println(" Valid license plate!");
        } else {
            System.out.println(" Invalid license plate! It must be in the format 'XX1234' (two letters followed by four digits).");
        }
        scanner.close();
    }
}
