import java.lang.reflect.Constructor;

class Student{
    private String name;

    public Student(String name){
        this.name = name;
    }

    public void display(){
        System.out.println("Name: " + name);
    }
}

public class DynamicallyCreateObjects {
    public static void main(String[] args) throws Exception {
        Class<?> c1 = Student.class;
        Constructor<?> constructor = c1.getConstructor(String.class);
        
        Student s1 = (Student) constructor.newInstance("Aryan");
        s1.display();

        Student s2 = (Student) constructor.newInstance("Rohan");
        s2.display();
;    }
}
