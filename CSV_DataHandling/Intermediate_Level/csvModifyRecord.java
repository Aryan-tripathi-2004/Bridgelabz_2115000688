import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;

import java.io.FileReader;
import java.io.FileWriter;

public class csvModifyRecord {
    public static void main(String[] args) {
        String path = "Employee.csv";
        String newpath = "output.csv";
        try(CSVReader reader = new CSVReader(new FileReader(path));
        CSVWriter writer = new CSVWriter(new FileWriter(newpath)))
        {
            String[] header = reader.readNext();
            writer.writeNext(header);
            String[] file;
            while ((file = reader.readNext()) != null){
                if (file[2].equals("IT")){
                    int newSalary = Integer.parseInt(file[3]) +  Integer.parseInt(file[3]) * 10 / 100;
                    file[3] = String.valueOf(newSalary);
                }
                writer.writeNext(file);
            }

        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
