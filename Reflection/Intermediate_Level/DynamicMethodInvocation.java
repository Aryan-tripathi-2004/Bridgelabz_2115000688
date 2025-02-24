import java.lang.reflect.*;
import java.util.*;

class MathOperations{
    public int add(int a, int b){
        return a+b;
    }
    public int subtract(int a, int b){
        return a-b;
    }
    public int multiply(int a, int b){
        return a*b;
    }
    public int divide(int a, int b){
        return a/b;
    }
}
public class DynamicMethodInvocation{
    public static void main(String args[]) throws Exception{
        Class c1 = MathOperations.class;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the method name: ");
        String methodName = sc.nextLine();
        System.out.print("Enter First Digit: ");
        int firstDigit = sc.nextInt();
        System.out.print("Enter Second Digit: ");
        int secondDigit = sc.nextInt(); 

        Method method = c1.getDeclaredMethod(methodName,int.class,int.class);
        int result = (int) method.invoke(new MathOperations(),firstDigit,secondDigit);
        System.out.println(result);
    }
}
