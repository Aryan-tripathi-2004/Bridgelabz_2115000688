package org.example;
import com.opencsv.CSVWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CSVReportDatabase {

    public static void main(String[] args) {
        String jdbcURL = "jdbc:mysql://localhost:3306/Divyanshu_DB";
        String username = "your_username";
        String password = "your_password";
        String csvFilePath = "employee_report.csv";
        String query = "SELECT employee_id, name, department, salary FROM employees";

        try (Connection connection = DriverManager.getConnection(jdbcURL, username, password);
             PreparedStatement statement = connection.prepareStatement(query);
             ResultSet resultSet = statement.executeQuery();
             CSVWriter writer = new CSVWriter(new FileWriter(csvFilePath))) {
             
            
            String[] header = {"Employee ID", "Name", "Department", "Salary"};
            writer.writeNext(header);
            
            while (resultSet.next()) {
                String employeeId = resultSet.getString("employee_id");
                String name = resultSet.getString("name");
                String department = resultSet.getString("department");
                String salary = resultSet.getString("salary"); 

                String[] record = {employeeId, name, department, salary};
                writer.writeNext(record);
            }
            
            System.out.println("CSV Report generated successfully at: " + csvFilePath);
        } catch (SQLException e) {
            System.err.println("Database error: " + e.getMessage());
        } catch (IOException e) {
            System.err.println("Error writing CSV file: " + e.getMessage());
        }
    }
}

