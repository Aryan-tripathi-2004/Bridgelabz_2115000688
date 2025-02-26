import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.fge.jsonschema.core.exceptions.ProcessingException;
import com.github.fge.jsonschema.main.JsonSchema;
import com.github.fge.jsonschema.main.JsonSchemaFactory;
import com.github.fge.jsonschema.main.JsonValidator;
import java.io.File;
import java.io.IOException;

public class JsonEmailValidation {
    public static void main(String[] args) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();

            JsonNode schemaNode = objectMapper.readTree(new File("schema.json"));
            JsonNode jsonData = objectMapper.readTree(new File("user.json"));

            JsonSchema schema = JsonSchemaFactory.byDefault().getJsonSchema(schemaNode);
            if (schema.validate(jsonData).isSuccess()) {
                System.out.println("Valid JSON: Email format is correct!");
            } else {
                System.out.println("Invalid JSON: Email format is incorrect!");
            }
        } catch (IOException | ProcessingException e) {
            e.printStackTrace();
        }
    }
}
