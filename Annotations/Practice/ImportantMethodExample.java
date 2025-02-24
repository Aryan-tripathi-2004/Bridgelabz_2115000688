import java.lang.annotation.*;
import java.lang.reflect.Method;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface ImportantMethod {
    String level() default "HIGH";
}

class CriticalOperations {
    @ImportantMethod
    void processData() {
        System.out.println("Processing data...");
    }

    @ImportantMethod(level = "MEDIUM")
    void logActivity() {
        System.out.println("Logging activity...");
    }

    void helperMethod() {
        System.out.println("Helper method, not critical.");
    }
}

public class ImportantMethodExample {
    public static void main(String[] args) {
        Method[] methods = CriticalOperations.class.getDeclaredMethods();

        for (Method method : methods) {
            if (method.isAnnotationPresent(ImportantMethod.class)) {
                ImportantMethod annotation = method.getAnnotation(ImportantMethod.class);
                System.out.println("Method: " + method.getName() + ", Importance Level: " + annotation.level());
            }
        }
    }
}
