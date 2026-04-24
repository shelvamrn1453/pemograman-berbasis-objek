import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("=== SISTEM MANAJEMEN DOSEN & MAHASISWA ===\n");
        
        // Input Data Dosen
        System.out.println("--- INPUT DATA DOSEN ---");
        System.out.print("Nama Dosen: ");
        String namaDosen = scanner.nextLine();
        System.out.print("Alamat: ");
        String alamatDosen = scanner.nextLine();
        
        Teacher dosen = new Teacher(namaDosen, alamatDosen);
        
        // Input mata kuliah yang diampu
        System.out.print("\nBerapa mata kuliah yang diampu? ");
        int jmlMK = scanner.nextInt();
        scanner.nextLine(); // clear buffer
        
        for (int i = 1; i <= jmlMK; i++) {
            System.out.print("Mata kuliah ke-" + i + ": ");
            String mk = scanner.nextLine();
            dosen.addCourse(mk);
        }
        
        // Input Data Mahasiswa
        System.out.println("\n--- INPUT DATA MAHASISWA ---");
        System.out.print("Nama Mahasiswa: ");
        String namaMhs = scanner.nextLine();
        System.out.print("Alamat: ");
        String alamatMhs = scanner.nextLine();
        
        Student mhs = new Student(namaMhs, alamatMhs);
        
        // Input mata kuliah yang diambil
        System.out.print("\nBerapa mata kuliah yang diambil? ");
        int jmlAmbil = scanner.nextInt();
        scanner.nextLine(); // clear buffer
        
        for (int i = 1; i <= jmlAmbil; i++) {
            System.out.print("\nMata kuliah ke-" + i + ": ");
            String mk = scanner.nextLine();
            System.out.print("Nilai (0-100): ");
            int nilai = scanner.nextInt();
            scanner.nextLine(); // clear buffer
            
            mhs.addCourseGrade(mk, nilai);
        }
        
        // Tampilkan Hasil
        System.out.println("\n=== HASIL INPUT ===");
        System.out.println("\n" + dosen);
        System.out.println("Mata kuliah yang diampu: " + jmlMK);
        
        System.out.println("\n" + mhs);
        System.out.println("Mata kuliah yang diambil: " + jmlAmbil);
        System.out.println("Rata-rata nilai: " + String.format("%.2f", mhs.getAverageGrade()));
        
        // Simulasi remove course
        System.out.println("\n=== SIMULASI HAPUS MATA KULIAH ===");
        System.out.print("Mata kuliah yang ingin dihapus (mahasiswa): ");
        String mkHapus = scanner.nextLine();
        
        if (mhs.removeCourse(mkHapus)) {
            System.out.println("✓ Berhasil menghapus " + mkHapus);
        } else {
            System.out.println("✗ Mata kuliah tidak ditemukan");
        }
        
        System.out.println("\nRata-rata nilai baru: " + String.format("%.2f", mhs.getAverageGrade()));
        
        scanner.close();
    }
}