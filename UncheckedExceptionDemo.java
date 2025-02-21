import java.util.InputMismatchException;
import java.util.Scanner;

public class UncheckedExceptionDemo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.print("Enter numerator: ");
            int num = scanner.nextInt();
            System.out.print("Enter denominator: ");
            int den = scanner.nextInt();

            int result = num / den;
            System.out.println("Result: " + result);
        } catch (ArithmeticException e) {
            System.out.println("Cannot divide by zero!");
        } catch (InputMismatchException e) {
            System.out.println("Invalid input! Please enter numbers only.");
        } finally {
            scanner.close();
        }
    }
}
