package org.example;

import com.opencsv.CSVReader;

import java.io.FileReader;
import java.util.regex.Pattern;

public class csvValidateRecords {
    private static final String EMAIL_REGEX = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$";
    private static final String PHONE_REGEX = "^\\d{10}$";
    public static void main(String[] args) {
        Pattern emailPattern = Pattern.compile(EMAIL_REGEX);
        Pattern phonePattern = Pattern.compile(PHONE_REGEX);
        String filePath = "data.csv";
        try (CSVReader csvReader = new CSVReader(new FileReader(filePath))) {
            String[] nextRecord;
            int lineNumber = 0;
            while ((nextRecord = csvReader.readNext()) != null) {
                lineNumber++;

                if (lineNumber == 1) {
                    continue;
                }

                if (nextRecord.length < 2) {
                    System.out.println(" Line " + lineNumber + ": Missing fields.");
                    continue;
                }

                String email = nextRecord[0].trim();
                String phone = nextRecord[1].trim();

                boolean isValid = true;
                StringBuilder errorMessage = new StringBuilder(" Line " + lineNumber + " errors: ");

                //  email
                if (!emailPattern.matcher(email).matches()) {
                    isValid = false;
                    errorMessage.append("Invalid email format. ");
                }

                //  phone number
                if (!phonePattern.matcher(phone).matches()) {
                    isValid = false;
                    errorMessage.append("Phone number must be exactly 10 digits.");
                }

                if (!isValid) {
                    System.out.println(errorMessage.toString());
                }
            }
        } catch (Exception e) {
            System.err.println("Error reading CSV file: " + e.getMessage());
        }
    }
}


