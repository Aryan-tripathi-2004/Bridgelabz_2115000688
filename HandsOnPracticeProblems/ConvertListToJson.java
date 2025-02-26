import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.*;
import java.io.File;

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

public class ConvertListToJson {
    public static void main(String[] args) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            List<Car> carList = Arrays.asList(
                new Car("Toyota", "Camry", 2020),
                new Car("Honda", "Civic", 2019),
                new Car("Ford", "Focus", 2021)
            );

            String jsonArray = objectMapper.writeValueAsString(carList);
            System.out.println(jsonArray);

            objectMapper.writeValue(new File("cars.json"), carList);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
