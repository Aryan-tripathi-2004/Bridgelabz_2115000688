import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LanguageExtractor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a text containing programming languages:");
        String input = scanner.nextLine();

        String extractedLanguages = extractLanguages(input);
        System.out.println("Extracted Languages: " + extractedLanguages);

        scanner.close();
    }

    public static String extractLanguages(String text) {
        Pattern pattern = Pattern.compile("\\b(Java|Python|JavaScript|Go)\\b");
        Matcher matcher = pattern.matcher(text);
        StringBuilder result = new StringBuilder();

        while (matcher.find()) {
            if (result.length() > 0) {
                result.append(", ");
            }
            result.append(matcher.group());
        }
        return result.toString();
    }
}
