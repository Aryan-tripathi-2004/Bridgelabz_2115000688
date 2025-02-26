import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.type.TypeReference;
import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import java.io.*;
import java.util.*;

public class IPLCensorAnalyzer {
    
    public static void main(String[] args) throws Exception {
        processJson("ipl_data.json", "censored_ipl_data.json");
        processCsv("ipl_data.csv", "censored_ipl_data.csv");
    }

    private static void processJson(String inputFile, String outputFile) throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        List<Map<String, Object>> matches = objectMapper.readValue(new File(inputFile), new TypeReference<>() {});
        
        for (Map<String, Object> match : matches) {
            match.put("team1", censorTeamName((String) match.get("team1")));
            match.put("team2", censorTeamName((String) match.get("team2")));
            match.put("player_of_match", "REDACTED");
        }
        
        objectMapper.writerWithDefaultPrettyPrinter().writeValue(new File(outputFile), matches);
        System.out.println("Censored JSON written to " + outputFile);
    }

    private static void processCsv(String inputFile, String outputFile) throws Exception {
        try (CSVReader reader = new CSVReader(new FileReader(inputFile));
             CSVWriter writer = new CSVWriter(new FileWriter(outputFile))) {
            
            List<String[]> allData = reader.readAll();
            allData.set(0, allData.get(0)); // Keep header
            
            for (int i = 1; i < allData.size(); i++) {
                String[] row = allData.get(i);
                row[1] = censorTeamName(row[1]);
                row[2] = censorTeamName(row[2]);
                row[6] = "REDACTED";
                allData.set(i, row);
            }
            
            writer.writeAll(allData);
            System.out.println("Censored CSV written to " + outputFile);
        }
    }

    private static String censorTeamName(String teamName) {
        int spaceIndex = teamName.lastIndexOf(" ");
        return (spaceIndex != -1) ? teamName.substring(0, spaceIndex) + " ***" : teamName;
    }
}
