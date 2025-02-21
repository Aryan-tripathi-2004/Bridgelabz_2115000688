import java.io.*;

class Person implements Serializable{
    private String id;
    private String name;
    private String department;
    private int salary;

    Person(String id, String name, String department,int salary){
        this.name = name;
        this.id = id;
        this.department = department;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Person{id='" + id + "', name=" + name + "', department=" + department + "', salary=" + salary +"}";
    }

}

public class Serialization{
    public static void main(String args[]){
        Person p1 = new Person("P001", "Aryan", "Computer Science", 100000);

        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("Person.ser"))){
            oos.writeObject(p1);
            System.out.println("Object Serialize successfully");
        }catch(IOException e){
            e.printStackTrace();
        }

        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream("Person.ser"))){
            Person deserializedPerson = (Person) ois.readObject();
            System.out.println("Deserialized Object: "+deserializedPerson);
        }catch(IOException | ClassNotFoundException e){
            e.printStackTrace();
        }
    }
}