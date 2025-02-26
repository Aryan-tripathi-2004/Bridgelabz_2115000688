import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.type.TypeReference;
import java.io.File;
import java.util.List;
import java.util.stream.Collectors;

class User {
    public String name;
    public int age;
    public String email;
}

public class FilterJsonData {
    public static void main(String[] args) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            List<User> users = objectMapper.readValue(new File("users.json"), new TypeReference<List<User>>() {});

            List<User> filteredUsers = users.stream()
                .filter(user -> user.age > 25)
                .collect(Collectors.toList());

            String resultJson = objectMapper.writeValueAsString(filteredUsers);
            System.out.println(resultJson);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
