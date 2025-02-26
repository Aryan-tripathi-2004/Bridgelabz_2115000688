import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.*;
import java.io.*;

class Car {
    public String brand;
    public String model;
    public int year;

    public Car(String brand, String model, int year) {
        this.brand = brand;
        this.model = model;
        this.year = year;
    }
}

public class ListToJsonArray {
    public static void main(String[] args) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();

            List<Car> cars = Arrays.asList(
                new Car("Toyota", "Corolla", 2020),
                new Car("Honda", "Civic", 2019),
                new Car("Ford", "Focus", 2021)
            );

            String jsonArray = objectMapper.writeValueAsString(cars);
            System.out.println(jsonArray);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
