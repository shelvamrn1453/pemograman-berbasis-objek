/* 
public class Exception {
    public static void main(String[] args) {
        int a[]=new int[5];
        a[5]=100;
    }
} 
*/

public class Soal1 {

    public static void main(String[] args) {
        int a[] = new int[5]; // Membuat array ukuran 5 [cite: 5, 12]
        
        try {
            a[5] = 100; // Mencoba mengakses indeks ke-5 [cite: 6, 16]
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Terjadi pelanggaran memory: Indeks melebihi batas!");
        }
    }
}