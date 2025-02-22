import java.util.Scanner;
import java.util.regex.*;

public class LinkExtractor {
    public static void extractLinks(String text) {
        Pattern pattern = Pattern.compile("https?://[\\w./-]+");
        Matcher matcher = pattern.matcher(text);
        boolean found = false;

        System.out.println(" Extracted Links:");
        while (matcher.find()) {
            System.out.println( matcher.group());
            found = true;
        }

        if (!found) {
            System.out.println(" No links found!");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter text containing URLs: ");
        String text = scanner.nextLine();

        extractLinks(text);
        scanner.close();
    }
}
