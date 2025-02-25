import java.io.*;

public class FilterRecord {
    public static void main(String[] args) {
        try(BufferedReader br = new BufferedReader(new FileReader("data.csv"))){
            int count = 0;
            String line;
            while((line=br.readLine())!=null){
                if(count==0){
                    count++;
                    continue;
                }
                String[] values = line.split(",");
                if(80<Integer.valueOf(values[values.length-1])){
                    System.out.println(line);
                }
            }
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}
