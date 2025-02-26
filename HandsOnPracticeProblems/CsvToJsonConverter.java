import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public class CsvToJsonConverter {
    public static void main(String[] args) {
        try {
            File csvFile = new File("data.csv");

            CsvSchema schema = CsvSchema.emptySchema().withHeader();
            CsvMapper csvMapper = new CsvMapper();

            MappingIterator<Map<String, String>> iterator = csvMapper.readerFor(Map.class).with(schema).readValues(csvFile);
            List<Map<String, String>> data = iterator.readAll();

            ObjectMapper jsonMapper = new ObjectMapper();
            String json = jsonMapper.writerWithDefaultPrettyPrinter().writeValueAsString(data);

            System.out.println(json);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
