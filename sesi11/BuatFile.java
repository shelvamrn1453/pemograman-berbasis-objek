import java.io.*;

public class BuatFile {
    public static void main(String[] args) {
        try{
            File f = new File ("file.txt");
            if(f.createNewFile()){
                System.out.println("file dibuat: " + f.getName());
            }else{
                System.out.println("file already exixts");
            }
        }
        catch (IOException e){
            System.out.println("an error occurred");
            e.printStackTrace();
        }
    }
    
}