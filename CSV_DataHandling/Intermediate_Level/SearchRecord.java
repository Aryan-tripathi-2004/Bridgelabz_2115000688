import java.io.*;

public class SearchRecord {
    public static void main(String[] args) throws Exception{
        String name = "Aryan";
        try(BufferedReader br = new BufferedReader(new FileReader("Employee.csv"))){
            String line;
            while((line=br.readLine())!=null){
                String arr[] = line.split(",");
                if(arr[1].equalsIgnoreCase(name)){
                    System.out.println(line);
                }
            }
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}
