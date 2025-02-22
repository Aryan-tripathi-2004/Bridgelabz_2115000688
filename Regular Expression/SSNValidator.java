import java.util.Scanner;
import java.util.regex.Pattern;

public class SSNValidator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a Social Security Number (SSN) to validate:");
        String input = scanner.nextLine();

        validateSSN(input);
        scanner.close();
    }

    public static void validateSSN(String ssn) {
        String regex = "\\d{3}-\\d{2}-\\d{4}";
        boolean isValid = Pattern.matches(regex, ssn);

        if (isValid) {
            System.out.println(" \"" + ssn + "\" is a valid SSN.");
        } else {
            System.out.println(" \"" + ssn + "\" is an invalid SSN.");
        }
    }
}
