import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class FilterJsonByAge {
    public static void main(String[] args) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode rootNode = objectMapper.readTree(new File("data.json"));

            List<JsonNode> filteredRecords = new ArrayList<>();
            for (JsonNode node : rootNode) {
                if (node.get("age").asInt() > 25) {
                    filteredRecords.add(node);
                }
            }

            String filteredJson = objectMapper.writeValueAsString(filteredRecords);
            System.out.println(filteredJson);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
