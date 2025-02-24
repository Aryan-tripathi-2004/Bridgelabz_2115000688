import java.lang.reflect.*;

class Person{
    private int age = 20;

    public Person(){
        System.out.println("public Constructor");
    }
}

public class AccessPrivateFeild {
    public static void main(String[] args) throws Exception {
        Class<?> c1 = Class.forName("Person");
        Person obj1 = new Person();
        Field f = c1.getDeclaredField("age");
        f.setAccessible(true);

        System.out.println("Before changing the value of age: ");
        System.out.println(f.get(obj1));

        System.out.println("After changing the value of age: ");
        f.set(obj1, 30);
        System.out.println(f.get(obj1));
    }
}
