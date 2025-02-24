import java.lang.annotation.*;
import java.lang.reflect.Method;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface LogExecutionTime {}

class ExecutionLogger {
    @LogExecutionTime
    void fastMethod() {
        for (int i = 0; i < 1000; i++);
    }

    @LogExecutionTime
    void slowMethod() {
        for (int i = 0; i < 1000000; i++);
    }
}

public class LogExecutionTimeExample {
    public static void main(String[] args) throws Exception {
        ExecutionLogger obj = new ExecutionLogger();
        Method[] methods = ExecutionLogger.class.getDeclaredMethods();

        for (Method method : methods) {
            if (method.isAnnotationPresent(LogExecutionTime.class)) {
                long start = System.nanoTime();
                method.invoke(obj);
                long end = System.nanoTime();
                System.out.println("Execution time of " + method.getName() + ": " + (end - start) + " nanoseconds");
            }
        }
    }
}
