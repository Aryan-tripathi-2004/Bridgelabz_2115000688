import java.lang.annotation.*;
import java.lang.reflect.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface Author{
    String name();
}

class AuthorDetails{
    @Author(name="Aryan")
    public void display(){
        System.out.println("Display Method");
    }
}
public class RetrieveAnnotationAtRunTime{
    public static void main(String[] args) throws Exception {
        Class<?> c1 = AuthorDetails.class;
        Method method = c1.getDeclaredMethod("display");

        if(method.isAnnotationPresent(Author.class)){
            Author author = method.getAnnotation(Author.class);
            System.out.println("Author Name: " + author.name());
        }

        method.invoke(new AuthorDetails());
    }
}