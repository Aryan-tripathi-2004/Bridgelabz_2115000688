package org.example;


import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class JsonCsvConverter {

    // Convert JSON file to CSV file
    public static void convertJsonToCsv(String jsonFilePath, String csvFilePath) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            List<Map<String, Object>> students = objectMapper.readValue(
                    new FileReader(jsonFilePath),
                    new TypeReference<List<Map<String, Object>>>() {}
            );
            
            if (students.isEmpty()) {
                System.out.println("JSON file is empty. No data to convert.");
                return;
            }
            
            Set<String> headerSet = new LinkedHashSet<>(students.get(0).keySet());
            String[] headers = headerSet.toArray(new String[0]);

            try (CSVWriter writer = new CSVWriter(new FileWriter(csvFilePath))) {
                writer.writeNext(headers);
                for (Map<String, Object> student : students) {
                    String[] row = new String[headers.length];
                    for (int i = 0; i < headers.length; i++) {
                        Object value = student.get(headers[i]);
                        row[i] = (value != null) ? value.toString() : "";
                    }
                    writer.writeNext(row);
                }
            }
            
            System.out.println("Converted JSON to CSV successfully. Output: " + csvFilePath);
        } catch (IOException e) {
            System.err.println("Error converting JSON to CSV: " + e.getMessage());
        }
    }

    public static void convertCsvToJson(String csvFilePath, String jsonFilePath) {
        ObjectMapper objectMapper = new ObjectMapper();
        List<Map<String, String>> students = new ArrayList<>();
        try (CSVReader reader = new CSVReader(new FileReader(csvFilePath))) {
            String[] headers = reader.readNext(); // Read header row
            if (headers == null) {
                System.out.println("CSV file is empty. No data to convert.");
                return;
            }
            String[] row;
            while ((row = reader.readNext()) != null) {
                Map<String, String> student = new LinkedHashMap<>();
                for (int i = 0; i < headers.length; i++) {
                    student.put(headers[i], i < row.length ? row[i] : "");
                }
                students.add(student);
            }
        } catch (Exception e) {
            System.err.println("Error reading CSV file: " + e.getMessage());
            return;
        }

        try (FileWriter writer = new FileWriter(jsonFilePath)) {
            String jsonOutput = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(students);
            writer.write(jsonOutput);
            System.out.println("Converted CSV to JSON successfully. Output: " + jsonFilePath);
        } catch (IOException e) {
            System.err.println("Error writing JSON file: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        String jsonInputFile = "students.json";   
        String csvOutputFile = "students.csv";      
        String jsonOutputFile = "students_converted.json"; 
        convertJsonToCsv(jsonInputFile, csvOutputFile);
        convertCsvToJson(csvOutputFile, jsonOutputFile);
    }
}
