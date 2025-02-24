import java.lang.reflect.*;
import java.util.*;
import java.lang.Exception;

class Class1{
    private String name;
    private int age;
    private String college = "GLA University, Mathura";

    public Class1(){
        name = "Unknown";
        age = 0;
    }
    public Class1(String name){
        this.name = name;
        age = 0;
    }
    public Class1(String name, int age){
        this.name = name;
        this.age = age;
    }

    public void display(){
        System.out.println("Name: "+name+" Age: "+age);
    }
    public void show(){
        System.out.println("Class1 Method");
    }

    private int add(int a, int b){
        return a+b;
    }

}

public class GetClassInformation{
    public static void main(String[] args) throws ClassNotFoundException {
        System.out.println("Enter class name to extract information about it:");
        Scanner sc = new Scanner(System.in);
        String className = sc.nextLine();

        System.out.println("-----------------Class Information-----------------");

        Class<?> c1 = Class.forName("Class1");
        System.out.println("Class Name: "+c1.getName());

        System.out.println("-----------------Constructor Information-----------------");

        Constructor<?> C1[] = c1.getDeclaredConstructors();
        for(Constructor<?> c : C1){
            System.out.println("Constructor Name: "+c.getName());
        }

        System.out.println("-----------------Method Information-----------------");

        Method M1[] = c1.getDeclaredMethods();
        for(Method m : M1){
            System.out.println("Method Name: "+m.getName());
        }

        System.out.println("-----------------Field Information-----------------");

        Field feilds[] = c1.getDeclaredFields();
        for(Field f : feilds){
            System.out.println("Feild Name: "+f.getName());
        }
    }
}
