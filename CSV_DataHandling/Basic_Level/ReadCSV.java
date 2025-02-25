import java.io.*;

public class ReadCSV {
    public static void main(String args[]) throws Exception{
        try(BufferedReader br = new BufferedReader(new FileReader("data.csv"))){
            String line;

            while((line = br.readLine())!= null){
                String arr[] = line.split(",");
                for(String s: arr){
                    System.out.print(s + " ");
                }
                System.out.println();
            }

        }catch(IOException e){
            e.printStackTrace();
        }
    }
}
