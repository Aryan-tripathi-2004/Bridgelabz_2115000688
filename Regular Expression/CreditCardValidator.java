import java.util.Scanner;

public class CreditCardValidator {
    public static boolean isValidCreditCard(String card) {
        return card.matches("^4\\d{15}$") || card.matches("^5\\d{15}$");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a credit card number: ");
        String card = scanner.nextLine();

        if (isValidCreditCard(card)) {
            System.out.println(" Valid credit card number!");
        } else {
            System.out.println(" Invalid credit card number! It must be a 16-digit Visa (starts with 4) or MasterCard (starts with 5).");
        }
        scanner.close();
    }
}
