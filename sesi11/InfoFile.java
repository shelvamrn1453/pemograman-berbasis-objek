import java.io.*;

public class InfoFile {
    public static void main(String[] args) {
        File f = new File ("file.txt");

        if(f.exists()){
            System.out.println("file nama: " + f.getName());
            System.out.println("abosolute path: " +  f.getAbsolutePath());
            System.out.println("writeable: " +  f.canWrite());
            System.out.println("readable: "  + f.canRead());
            System.out.println("file size: " + f.length());
        }
        else{
            System.out.println("file tidak ada");
        }
        
    }
}
