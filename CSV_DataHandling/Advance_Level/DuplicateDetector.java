package org.example;

import com.opencsv.CSVReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DuplicateDetector {

    public static void main(String[] args) {
        String csvFile = "data.csv";  
        detectDuplicates(csvFile);
    }

    public static void detectDuplicates(String filePath) {
        Map<String, List<String[]>> recordsById = new HashMap<>();

        try (CSVReader reader = new CSVReader(new FileReader(filePath))) {
            String[] row;
            int lineNumber = 0;

            // Read each row from the CSV file
            while ((row = reader.readNext()) != null) {
                lineNumber++;
                if (lineNumber == 1) {
                    continue;
                }

                String id = row[0].trim();
                recordsById.computeIfAbsent(id, k -> new ArrayList<>()).add(row);
            }
        } catch (Exception e) {
            System.err.println("Error reading CSV file: " + e.getMessage());
            return;
        }

        System.out.println("Duplicate Records based on ID:");
        boolean duplicatesFound = false;
        for (Map.Entry<String, List<String[]>> entry : recordsById.entrySet()) {
            String id = entry.getKey();
            List<String[]> records = entry.getValue();
            if (records.size() > 1) {
                duplicatesFound = true;
                System.out.println("ID: " + id + " (Found " + records.size() + " times)");
                for (String[] record : records) {
                    System.out.println("  " + String.join(", ", record));
                }
                System.out.println();
            }
        }
        if (!duplicatesFound) {
            System.out.println("No duplicate records found based on the ID column.");
        }
    }
}

