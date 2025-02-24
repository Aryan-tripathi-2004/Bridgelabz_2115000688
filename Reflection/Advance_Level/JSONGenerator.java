import java.lang.reflect.*;
import java.util.*;

class Product {
    public String name = "Laptop";
    public double price = 999.99;
}

public class JSONGenerator {
    public static String toJson(Object obj) throws Exception {
        Class<?> clazz = obj.getClass();
        StringBuilder json = new StringBuilder("{");
        for (Field field : clazz.getDeclaredFields()) {
            field.setAccessible(true);
            json.append("\"").append(field.getName()).append("\":\"").append(field.get(obj)).append("\",");
        }
        return json.substring(0, json.length() - 1) + "}";
    }

    public static void main(String[] args) throws Exception {
        System.out.println(toJson(new Product()));
    }
}
