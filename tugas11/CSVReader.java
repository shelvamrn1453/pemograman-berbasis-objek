import java.io.BufferedReader;
import java.io.FileReader;    
import java.io.IOException;   

public class CSVReader {
    public static void main(String[] args) {
        String csvFile = "students.csv"; 
        String line;
        String csvSplitBy = ","; 
        int indeks = 0; // Variabel untuk menghitung baris

        System.out.println("NIM, NAMA, UMUR, PRODI");

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            while ((line = br.readLine()) != null) { 
                indeks++; // Setiap ada baris baru, angka bertambah 1
                
                if (indeks > 1) {
                    String[] student = line.split(csvSplitBy);
                    for (int i = 0; i < student.length; i++) {
                        System.out.print(student[i] + " ");
                    }
                    System.out.println(); 
                }
            }
            
            // Menampilkan total data (indeks dikurangi 1 karena baris pertama adalah judul)
            System.out.println("--------------------------------");
            System.out.println("Total jumlah baris data mahasiswa: " + (indeks - 1));
            
        } catch (IOException e) {
            e.printStackTrace(); 
        }
    }
}

/* output
PS C:\TUGASKULIAH\semester4\tugas11> java CSVReader      
NIM, NAMA, UMUR, PRODI
01 Andri 21 TI 
02 Bebeb 22 TI 
03 Cica 21 TE 
04 Dedi 22 TE 
--------------------------------
Total jumlah baris data mahasiswa: 4 
*/