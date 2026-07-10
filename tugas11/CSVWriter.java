import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner; // Mengimpor Scanner untuk membaca input keyboard

public class CSVWriter {
    public static void main(String[] args) {
        String csvFile = "new_students.csv"; 
        Scanner input = new Scanner(System.in); // Membuat objek Scanner

        // Menggunakan mode 'true' agar data baru ditambahkan di bawah (append)
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(csvFile, true))) {
            
            System.out.println("--- Input Data Mahasiswa Baru ---");
            System.out.print("Masukkan NIM   : ");
            String nim = input.nextLine();
            
            System.out.print("Masukkan Nama  : ");
            String nama = input.nextLine();
            
            System.out.print("Masukkan Umur  : ");
            String umur = input.nextLine();
            
            System.out.print("Masukkan Prodi : ");
            String prodi = input.nextLine();

            // Menggabungkan semua input menjadi format CSV (dipisahkan koma)
            String dataBaru = nim + ", " + nama + ", " + umur + ", " + prodi;

            // Menulis ke file
            bw.write(dataBaru);
            bw.newLine(); 
            
            System.out.println("Data berhasil ditambahkan ke " + csvFile);
            
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            input.close(); // Menutup scanner setelah selesai digunakan
        }
    }
}

/* outputPS C:\TUGASKULIAH\semester4\tugas11> java CSVWriter
--- Input Data Mahasiswa Baru ---
Masukkan NIM   : 20240040075
Masukkan Nama  : shelva
Masukkan Umur  : 21
Masukkan Prodi : TI 
Data berhasil ditambahkan ke new_students.csv */