import java.io.*;

public class FileHandling{
    public static void main(String args[]){
        try(FileInputStream fis = new FileInputStream("Input.txt");
            FileOutputStream fos = new FileOutputStream("Output.txt")){

            int byteData;
            while((byteData=fis.read())!=-1){
                fos.write(byteData);
            }

            System.out.println("File copied successfully");

        }catch(FileNotFoundException e){
            System.out.println("File not Found : "+e.getMessage());
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }
}