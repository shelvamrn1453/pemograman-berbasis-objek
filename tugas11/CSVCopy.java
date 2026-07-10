import java.io.BufferedReader;
import java.io.FileReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class CSVCopy {
    public static void main(String[] args) {
        String sourceFile = "students.csv";      // File asal yang akan disalin
        String destFile = "students_copy.csv";  // File tujuan hasil salinan
        String line;

        // Membuka BufferedReader (untuk membaca) dan BufferedWriter (untuk menulis) secara bersamaan
        try (BufferedReader br = new BufferedReader(new FileReader(sourceFile));
             BufferedWriter bw = new BufferedWriter(new FileWriter(destFile))) {
            
            // Perulangan untuk membaca file asal baris demi baris hingga habis
            while ((line = br.readLine()) != null) {
                bw.write(line); // Langsung menuliskan baris yang dibaca ke file tujuan
                bw.newLine();   // Memberikan baris baru di file tujuan
            }
            
            System.out.println("File berhasil disalin dari " + sourceFile + " ke " + destFile);
            
        } catch (IOException e) {
            e.printStackTrace(); // Menampilkan pesan error jika proses salin gagal
        }
    }
}

/* output
PS C:\TUGASKULIAH\semester4\tugas11> java CSVCopy
File berhasil disalin dari students.csv ke students_copy.csv */