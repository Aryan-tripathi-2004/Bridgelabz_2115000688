import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.util.Iterator;
import java.util.Map;

public class ReadJsonKeysValues {
    public static void main(String[] args) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode rootNode = objectMapper.readTree(new File("data.json"));
            printJson(rootNode, "");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void printJson(JsonNode node, String prefix) {
        if (node.isObject()) {
            Iterator<Map.Entry<String, JsonNode>> fields = node.fields();
            while (fields.hasNext()) {
                Map.Entry<String, JsonNode> entry = fields.next();
                printJson(entry.getValue(), prefix + entry.getKey() + ": ");
            }
        } else if (node.isArray()) {
            for (JsonNode element : node) {
                printJson(element, prefix);
            }
        } else {
            System.out.println(prefix + node.asText());
        }
    }
}
