import java.util.Scanner;

public class RemoveExtraSpaces {
    public static String removeExtraSpaces(String text) {
        return text.replaceAll("\\s+", " ").trim();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a sentence with extra spaces: ");
        String text = scanner.nextLine();

        System.out.println(" Cleaned Text: " + removeExtraSpaces(text));
        scanner.close();
    }
}
