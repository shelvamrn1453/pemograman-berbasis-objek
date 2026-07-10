//PR bagaimana cara meguodatebukan menimpa
//isi file.txt sebelumnya adalah "halo ini shelva"
import java.io.*;

public class TulisFile {
    public static void main(String[] args) {
        try{
            FileWriter f = new FileWriter("file.txt");
            f.write("belajar pemograman file handling"); //ini hanya menimpa bukan meng update
            f.close();
            System.out.println("proses berhasil");
        }
        catch (IOException e){
            System.out.println("terjadi kesalahan dalam penulisan file");
            System.out.println(e.getMessage());
        }
    }
}
