import java.util.Scanner;
import java.util.regex.*;

public class EmailExtractor {
    public static void extractEmails(String text) {
        Pattern pattern = Pattern.compile("[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}");
        Matcher matcher = pattern.matcher(text);
        boolean found = false;

        System.out.println(" Extracted Emails:");
        while (matcher.find()) {
            System.out.println(matcher.group());
            found = true;
        }

        if (!found) {
            System.out.println(" No email addresses found!");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter text containing emails: ");
        String text = scanner.nextLine();

        extractEmails(text);
        scanner.close();
    }
}
