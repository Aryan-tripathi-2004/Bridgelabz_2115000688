import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RepeatingWordsFinder {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a sentence:");
        String input = scanner.nextLine();

        findRepeatingWords(input);
        scanner.close();
    }

    public static void findRepeatingWords(String text) {
        Pattern pattern = Pattern.compile("\\b(\\w+)\\b(?:\\s+\\1\\b)+", Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(text);

        System.out.println("Repeating Words:");
        while (matcher.find()) {
            System.out.println(matcher.group(1));
        }
    }
}
