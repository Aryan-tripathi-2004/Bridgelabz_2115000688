import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DateExtractor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a text containing dates:");
        String input = scanner.nextLine();

        extractDates(input);
        scanner.close();
    }

    public static void extractDates(String text) {
        Pattern pattern = Pattern.compile("\\b\\d{2}/\\d{2}/\\d{4}\\b");
        Matcher matcher = pattern.matcher(text);

        System.out.println("Extracted Dates:");
        while (matcher.find()) {
            System.out.println(matcher.group());
        }
    }
}
