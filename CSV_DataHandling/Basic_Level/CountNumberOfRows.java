import java.io.*;

public class CountNumberOfRows  {
    public static void main(String[] args) throws Exception{
        try(BufferedReader br = new BufferedReader(new FileReader("data.csv"))){
            int count = 0;
            while(br.readLine() != null){
                count++;
            }
            System.out.println("Number of rows in the CSV file: " + count);

        }catch(IOException e){
            e.printStackTrace();
        }
    }
}
