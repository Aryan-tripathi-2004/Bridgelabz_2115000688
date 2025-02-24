import java.lang.annotation.*;
import java.lang.reflect.Method;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface Todo {
    String task();
    String assignedTo();
    String priority() default "MEDIUM";
}

class ProjectTasks {
    @Todo(task = "Implement user authentication", assignedTo = "Bhoovan", priority = "HIGH")
    void userAuthentication() {
        System.out.println("Authenticating user...");
    }

    @Todo(task = "Optimize database queries", assignedTo = "Rahul")
    void optimizeQueries() {
        System.out.println("Optimizing queries...");
    }

    @Todo(task = "Improve UI responsiveness", assignedTo = "Ananya", priority = "LOW")
    void improveUI() {
        System.out.println("Enhancing UI responsiveness...");
    }
}

public class TodoAnnotationExample {
    public static void main(String[] args) {
        Method[] methods = ProjectTasks.class.getDeclaredMethods();

        for (Method method : methods) {
            if (method.isAnnotationPresent(Todo.class)) {
                Todo todo = method.getAnnotation(Todo.class);
                System.out.println("Task: " + todo.task());
                System.out.println("Assigned To: " + todo.assignedTo());
                System.out.println("Priority: " + todo.priority());
                System.out.println("------------------------");
            }
        }
    }
}
