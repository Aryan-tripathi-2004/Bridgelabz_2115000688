import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CurrencyExtractor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a text containing currency values:");
        String input = scanner.nextLine();

        extractCurrency(input);
        scanner.close();
    }

    public static void extractCurrency(String text) {
        Pattern pattern = Pattern.compile("\\$?\\d+(\\.\\d{2})?");
        Matcher matcher = pattern.matcher(text);

        System.out.println("Extracted Currency Values:");
        while (matcher.find()) {
            System.out.println(matcher.group());
        }
    }
}
