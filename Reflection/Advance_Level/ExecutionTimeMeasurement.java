import java.lang.reflect.*;

class Task {
    public void runTask() {
        for (int i = 0; i < 1000000; i++)
            ;
    }
}

public class ExecutionTimeMeasurement {
    public static void main(String[] args) throws Exception {
        Task task = new Task();
        Method method = Task.class.getMethod("runTask");

        long startTime = System.nanoTime();
        method.invoke(task);
        long endTime = System.nanoTime();

        System.out.println("Execution Time: " + (endTime - startTime) + " ns");
    }
}
