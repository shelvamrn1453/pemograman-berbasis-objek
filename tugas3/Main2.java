import java.util.Scanner;

public class Main2 {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        
        int totalMhs = 0;
        int totalNilai = 0;
        int jumlahLulus = 0;
        int jumlahTidakLulus = 0;
        String namaLulus = "";
        String namaTidakLulus = "";
        int jumlahGradeA = 0, jumlahGradeB = 0, jumlahGradeC = 0, jumlahGradeD = 0, jumlahGradeE = 0;
        String namaGradeA = "", namaGradeB = "", namaGradeC = "", namaGradeD = "", namaGradeE = "";
        String detailNilai = "";
        
        NilaiMahasiswa[] mhs = new NilaiMahasiswa[4];
        
        System.out.println("=== INPUT DATA NILAI MAHASISWA ===\n");
        
        for (int i = 0; i < 4; i++) {
            System.out.println("Data Mahasiswa Ke-" + (i + 1));
            System.out.print("Masukkan Nama : ");
            String nama = sc.nextLine(); 
            System.out.print("Masukkan NIM : ");
            String nim = sc.nextLine();
            System.out.print("Masukkan Nilai : ");
            int nilai = sc.nextInt(); 
            sc.nextLine();
            
            mhs[i] = new NilaiMahasiswa(nama, nim, nilai);
            
            System.out.println("NIM   : " + mhs[i].getNim());
            System.out.println("Nama  : " + mhs[i].getNama());
            System.out.println("Nilai : " + mhs[i].getNilai());
            System.out.println("Grade : " + mhs[i].getGrade());  
            System.out.println("===========================================\n");  
            
            //Statistik
            totalMhs++;
            
            if (mhs[i].getNilai() >= 0 && mhs[i].getNilai() <= 100) {
                totalNilai += mhs[i].getNilai();
                
                // Detail perhitungan rata-rata
                if (detailNilai.isEmpty()) {
                    detailNilai = String.valueOf(mhs[i].getNilai());
                } else {
                    detailNilai = detailNilai + "+" + mhs[i].getNilai();
                }
                
                // Lulus/Tidak Lulus
                if (mhs[i].getGrade().equals("A") || mhs[i].getGrade().equals("B") || mhs[i].getGrade().equals("C")) {
                    jumlahLulus++;
                    if (namaLulus.isEmpty()) {
                        namaLulus = mhs[i].getNama();
                    } else {
                        namaLulus = namaLulus + ", " + mhs[i].getNama();
                    }
                } else {
                    jumlahTidakLulus++;
                    if (namaTidakLulus.isEmpty()) {
                        namaTidakLulus = mhs[i].getNama();
                    } else {
                        namaTidakLulus = namaTidakLulus + ", " + mhs[i].getNama();
                    }
                }
                
                // Per Grade
                if (mhs[i].getGrade().equals("A")) {
                    jumlahGradeA++;
                    if (namaGradeA.isEmpty()) {
                        namaGradeA = mhs[i].getNama();
                    } else {
                        namaGradeA = namaGradeA + ", " + mhs[i].getNama();
                    }
                } else if (mhs[i].getGrade().equals("B")) {
                    jumlahGradeB++;
                    if (namaGradeB.isEmpty()) {
                        namaGradeB = mhs[i].getNama();
                    } else {
                        namaGradeB = namaGradeB + ", " + mhs[i].getNama();
                    }
                } else if (mhs[i].getGrade().equals("C")) {
                    jumlahGradeC++;
                    if (namaGradeC.isEmpty()) {
                        namaGradeC = mhs[i].getNama();
                    } else {
                        namaGradeC = namaGradeC + ", " + mhs[i].getNama();
                    }
                } else if (mhs[i].getGrade().equals("D")) {
                    jumlahGradeD++;
                    if (namaGradeD.isEmpty()) {
                        namaGradeD = mhs[i].getNama();
                    } else {
                        namaGradeD = namaGradeD + ", " + mhs[i].getNama();
                    }
                } else if (mhs[i].getGrade().equals("E")) {
                    jumlahGradeE++;
                    if (namaGradeE.isEmpty()) {
                        namaGradeE = mhs[i].getNama();
                    } else {
                        namaGradeE = namaGradeE + ", " + mhs[i].getNama();
                    }
                }
            }
        }
        
        //Rata-rata dihitung SETELAH loop
        double rataRata = (double) totalNilai / totalMhs;
        
        System.out.println("=== REKAPITULASI ===");
        System.out.println("Jumlah Mahasiswa : " + totalMhs);
        System.out.println("Jumlah Mahasiswa yg Lulus : " + jumlahLulus + " yaitu " + namaLulus);
        System.out.println("Jumlah Mahasiswa yg Tidak Lulus : " + jumlahTidakLulus + " yaitu " + namaTidakLulus);
        
        if (jumlahGradeA > 0) {
            System.out.println("Jumlah Mahasiswa dengan Nilai A = " + jumlahGradeA + " yaitu " + namaGradeA);
        }
        if (jumlahGradeB > 0) {
            System.out.println("Jumlah Mahasiswa dengan Nilai B = " + jumlahGradeB + " yaitu " + namaGradeB);
        }
        if (jumlahGradeC > 0) {
            System.out.println("Jumlah Mahasiswa dengan Nilai C = " + jumlahGradeC + " yaitu " + namaGradeC);
        }
        if (jumlahGradeD > 0) {
            System.out.println("Jumlah Mahasiswa dengan Nilai D = " + jumlahGradeD + " yaitu " + namaGradeD);
        }
        if (jumlahGradeE > 0) {
            System.out.println("Jumlah Mahasiswa dengan Nilai E = " + jumlahGradeE + " yaitu " + namaGradeE);
        }
        
        System.out.println("Rata-rata nilai mahasiswa adalah : " + detailNilai + " / " + totalMhs + " = " + rataRata);
        
        sc.close();
    }   
}