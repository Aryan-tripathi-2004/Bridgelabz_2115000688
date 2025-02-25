import com.opencsv.CSVReader;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class csvSortRecords {
    public static void main(String[] args) {
        String path = "output.csv";
        List<String[]> records = new ArrayList<>();
        try(CSVReader reader =new CSVReader(new FileReader(path))){
            reader.readNext();
            String[] record;
            while ((record = reader.readNext()) != null){
                records.add(record);
            }
            records.sort((r1 ,r2) -> Double.compare(Double.parseDouble(r2[3]), Double.parseDouble(r1[3])));

            for (int i = 0; i < Math.min(5 , records.size()); i++) {
                String[] employee = records.get(i);
                System.out.println(employee[0] + " | " +  employee[1] + " | " + employee[2] + " | " + employee[3]);
            }
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
