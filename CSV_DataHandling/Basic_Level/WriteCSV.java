import java.io.*;

public class WriteCSV {
    public static void main(String args[]) throws Exception{
        try(BufferedWriter bw = new BufferedWriter(new FileWriter("data.csv", true))){
            bw.write("6,shlok,22,94");
            bw.newLine();
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}
