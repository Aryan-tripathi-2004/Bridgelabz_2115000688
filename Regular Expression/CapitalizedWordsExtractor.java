import java.util.Scanner;
import java.util.regex.*;

public class CapitalizedWordsExtractor {
    public static void extractCapitalizedWords(String text) {
        Pattern pattern = Pattern.compile("\\b[A-Z][a-z]*\\b");
        Matcher matcher = pattern.matcher(text);
        boolean found = false;

        System.out.println(" Extracted Capitalized Words:");
        while (matcher.find()) {
            System.out.println(matcher.group());
            found = true;
        }

        if (!found) {
            System.out.println(" No capitalized words found!");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a sentence: ");
        String text = scanner.nextLine();

        extractCapitalizedWords(text);
        scanner.close();
    }
}
