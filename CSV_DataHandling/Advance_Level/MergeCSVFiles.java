package org.example;
import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.HashMap;
import java.util.Map;

public class MergeCSVFiles {
    
    public static void main(String[] args) {
        String file1 = "students1.csv"; 
        String file2 = "students2.csv"; 
        String outputFile = "merged_students.csv";
        
        Map<String, String[]> studentDetails = new HashMap<>();
        
        // Read students1.csv and store details in the map
        try (CSVReader reader1 = new CSVReader(new FileReader(file1))) {
            String[] row;
            boolean header = true;
            while ((row = reader1.readNext()) != null) {
                // Skip header row
                if (header) {
                    header = false;
                    continue;
                }
                if (row.length < 3) {
                    System.err.println("Invalid row in " + file1 + ": " + String.join(",", row));
                    continue;
                }
                String id = row[0].trim();
                String name = row[1].trim();
                String age = row[2].trim();
                studentDetails.put(id, new String[]{name, age});
            }
        } catch (Exception e) {
            System.err.println("Error reading " + file1 + ": " + e.getMessage());
            return;
        }
        
        try (CSVReader reader2 = new CSVReader(new FileReader(file2));
             CSVWriter writer = new CSVWriter(new FileWriter(outputFile))) {
            String[] header = {"ID", "Name", "Age", "Marks", "Grade"};
            writer.writeNext(header);
            String[] row;
            boolean headerRow = true;
            while ((row = reader2.readNext()) != null) {
                if (headerRow) {
                    headerRow = false;
                    continue;
                }
                if (row.length < 3) {
                    System.err.println("Invalid row in " + file2 + ": " + String.join(",", row));
                    continue;
                }
                
                String id = row[0].trim();
                String marks = row[1].trim();
                String grade = row[2].trim();
                
                if (studentDetails.containsKey(id)) {
                    String[] details = studentDetails.get(id); // [Name, Age]
                    String[] mergedRow = { id, details[0], details[1], marks, grade };
                    writer.writeNext(mergedRow);
                } else {
                    System.err.println("Warning: ID " + id + " found in " + file2 + " but not in " + file1);
                }
            }
            
            System.out.println("Merge complete. Output file: " + outputFile);
            
        } catch (Exception e) {
            System.err.println("Error processing " + file2 + " or writing output file: " + e.getMessage());
        }
    }
}
