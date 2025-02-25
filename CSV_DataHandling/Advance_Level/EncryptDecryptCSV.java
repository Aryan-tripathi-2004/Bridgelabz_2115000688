package org.example;
import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.io.FileReader;
import java.io.FileWriter;
import java.security.Key;
import java.util.Base64;

public class EncryptDecryptCSV {

    private static final String ALGORITHM = "AES";
    private static final byte[] KEY_VALUE = new byte[] {
        'T', 'h', 'e', 'B', 'e', 's', 't', 'S', 'e', 'c', 'r', 'e', 't', 'K', 'e', 'y'
    };

    public static String encrypt(String value) throws Exception {
        Key key = generateKey();
        Cipher cipher = Cipher.getInstance(ALGORITHM);
        cipher.init(Cipher.ENCRYPT_MODE, key);
        byte[] encryptedBytes = cipher.doFinal(value.getBytes("UTF-8"));
        return Base64.getEncoder().encodeToString(encryptedBytes);
    }

    public static String decrypt(String value) throws Exception {
        Key key = generateKey();
        Cipher cipher = Cipher.getInstance(ALGORITHM);
        cipher.init(Cipher.DECRYPT_MODE, key);
        byte[] decodedValue = Base64.getDecoder().decode(value);
        byte[] decryptedBytes = cipher.doFinal(decodedValue);
        return new String(decryptedBytes, "UTF-8");
    }

    private static Key generateKey() throws Exception {
        return new SecretKeySpec(KEY_VALUE, ALGORITHM);
    }

    public static void writeCSV(String csvFilePath) {
        String[][] data = {
            {"EmployeeID", "Name", "Email", "Salary"},
            {"101", "Alice Johnson", "alice.johnson@example.com", "75000"},
            {"102", "Bob Smith", "bob.smith@example.com", "82000"},
            {"103", "Charlie Brown", "charlie.brown@example.com", "67000"}
        };

        try (CSVWriter writer = new CSVWriter(new FileWriter(csvFilePath))) {
            writer.writeNext(data[0]);

            for (int i = 1; i < data.length; i++) {
                String[] row = data[i].clone();
                row[2] = encrypt(row[2]);
                row[3] = encrypt(row[3]);
                writer.writeNext(row);
            }
            System.out.println("CSV file written with encrypted sensitive data: " + csvFilePath);
        } catch (Exception e) {
            System.err.println("Error writing CSV file: " + e.getMessage());
        }
    }

    public static void readCSV(String csvFilePath) {
        try (CSVReader reader = new CSVReader(new FileReader(csvFilePath))) {
            String[] row;
            int lineNumber = 0;
            while ((row = reader.readNext()) != null) {
                lineNumber++;
               
                if (lineNumber == 1) {
                    System.out.println(String.join(" | ", row));
                    continue;
                }
                
                String[] decryptedRow = row.clone();
                try {
                    decryptedRow[2] = decrypt(row[2]);
                    decryptedRow[3] = decrypt(row[3]);
                } catch (Exception e) {
                    System.err.println("Error decrypting row " + lineNumber + ": " + e.getMessage());
                }
                System.out.println(String.join(" | ", decryptedRow));
            }
        } catch (Exception e) {
            System.err.println("Error reading CSV file: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        String csvFile = "employee_data_encrypted.csv";
                writeCSV(csvFile);
                System.out.println("\nReading and decrypting CSV data:");
        readCSV(csvFile);
    }
}
