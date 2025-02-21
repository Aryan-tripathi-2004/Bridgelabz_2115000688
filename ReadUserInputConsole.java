import java.io.*;

public class ReadUserInputConsole{
    public static void main(String args[]){
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new FileWriter("Output.txt", true)))
        {   
            System.out.println("Enter Your Name : ");
            String name = br.readLine();
            System.out.println("Enter Your Age: ");
            int age = br.read();
            br.readLine();
            System.out.println("Enter Your Fav.Progeamming language: ");
            String language = br.readLine();
            
                bw.write("\nName: "+name+" Age: "+age+" Language: "+language);
                bw.newLine();

                System.out.println("Input data is written on Output.txt");
        } catch(IOException e){
            e.printStackTrace();
        }
    }
}