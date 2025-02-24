import java.lang.reflect.*;

class Configuration{
    private static String API_Key = "123-456-789";
}

public class ModifyStaticfields{
    public static void main(String[] args) throws Exception{
        Configuration configuration = new Configuration();
        Class<?> c1 = configuration.getClass();

        Field field = c1.getDeclaredField("API_Key");
        field.setAccessible(true);

        System.out.println("-----------------Before Modification-----------------");
        System.out.println("API Key: " + field.get(configuration));

        System.out.println("-----------------After Modification-----------------");
        field.set(configuration,"987-654-321");
        System.out.println("API Key: " + field.get(configuration));
    }
}