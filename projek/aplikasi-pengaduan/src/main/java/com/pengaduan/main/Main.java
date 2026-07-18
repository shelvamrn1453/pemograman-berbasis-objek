package com.pengaduan.main;

import com.pengaduan.service.PengaduanService;
import com.pengaduan.service.TanggapanService;
import com.pengaduan.model.Pengaduan;
import com.pengaduan.model.RiwayatPengaduan;
import com.pengaduan.model.Tanggapan;
import com.pengaduan.model.Petugas;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.List;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static PengaduanService ps = new PengaduanService();
    static TanggapanService ts = new TanggapanService();
    static Petugas petugas = new Petugas("joko", "jokowi", "sayaakanlawan", "P1");
    
    public static void main(String[] args) {
        boolean berjalan = true;

        while(berjalan){
            petugas.tampilMenu();
            System.out.println("Pilih Menu: ");

            try{
                int pilihan = sc.nextInt();
                
                switch (pilihan) {
                    case 1:
                        menuKelolaPengaduan();
                        break;
                    case 2:
                        menuKelolaTanggapan();
                        break;
                    case 3:
                        berjalan = false;
                        System.out.println("Terima kasih telah menggunakan Aplikasi Manajemen Pengaduan Masyarakat.");
                        break;
                    default:
                        System.out.println("pilihan tidak valid, coba lagi");
                        
                }
            }
            catch(InputMismatchException e){
                System.out.println("input harus berupa angka!");;
                sc.next(); //buang input yang salah biar ga infinite loop
            }
        }
        sc.close();
    }

    static void menuKelolaPengaduan(){
        boolean kembali = false;

        while (!kembali) {
            System.out.println("\n--- KELOLA PENGADUAN ---");
            System.out.println("Total pengaduan saat ini : " + ps.getTotalPengaduan());
            System.out.println("1. Tambah Pengaduan");
            System.out.println("2. Lihat Daftar Pengaduan");
            System.out.println("3. Edit Pengaduan");
            System.out.println("4. Hapus pengaduan");
            System.out.println("5. Kembali");
            System.out.print("Pilih menu: ");

            try{
                int pilihan = sc.nextInt();
                sc.nextLine(); //buang neline sisa setelah nextInt()
                switch (pilihan) {
                    case 1:
                        System.out.print("Nama Pelapor: ");
                        String nama = sc.nextLine();
                        System.out.println("Isi pengaduan: ");
                        String isi = sc.nextLine();
                        ps.tambahPengaduan(nama, isi);
                        break;
                    
                    case 2:
                        List<Pengaduan> daftarPengaduan = ps.getAllPengaduan();
                        System.out.println("\n--- DAFTAR PENGADUAN ---");
                        if(daftarPengaduan.isEmpty()){
                            System.out.println("belum ada data pengaduan");
                        }
                        else{
                            for(Pengaduan p : daftarPengaduan){
                                System.out.println(p.getIdPengaduan() + " | " + p.getNamaPelapor() + " | " + p.getIsiPengaduan() + " | " + p.getStatus());
                            }
                        }
                        break;

                    case 3:
                        System.out.print("ID pengaduan yang mau diedit: ");
                        int idEdit = sc.nextInt();
                        sc.nextLine();
                        System.out.println("Isi pengaduan baru: ");
                        String isiBaru = sc.nextLine();
                        ps.updatePengaduan(idEdit, isiBaru);
                        break;

                    case 4:
                        System.out.println("ID pengaduan yang mau dihapus: ");
                        int idHapus = sc.nextInt();
                        ps.hapusPengaduan(idHapus);
                        break;

                    case 5:
                        kembali = true;
                        break;
                    default:
                        System.out.println("Pilihan tidak valid, coba lagi");
                }
            }
            catch(InputMismatchException e){
                System.out.println("Input harus berupa angka!");
                sc.next();
            }
        }
    }

    static void menuKelolaTanggapan(){
        boolean kembali = false;

        while (!kembali) {
            System.out.println("\n--- KELOLA TANGGAPAN ---");
            System.out.println("1. Tambah Tanggapan");
            System.out.println("2. Lihat Daftar Riwayat Tanggapan");
            System.out.println("3. Kembali");
            System.out.print("Pilih menu: ");

            try{
                int pilihan = sc.nextInt();
                sc.nextLine();

                switch (pilihan) {
                    case 1:
                        System.out.print("Id Tanggapan: ");
                        int id = sc.nextInt();
                        sc.nextLine();
                        System.out.print("Isi Tanggapan: ");
                        String isi = sc.nextLine();
                        ts.beriTanggapan(id, isi);
                        break;
                
                    case 2:
                        List<RiwayatPengaduan> daftarTanggapan = ts.getRiwayat();
                        System.out.println("\n--- DAFTAR TANGGAPAN ---");
                        if(daftarTanggapan.isEmpty()){
                            System.out.println("Belum ada data tanggapan");
                        }
                        else{
                            for (RiwayatPengaduan r   : daftarTanggapan){
                                System.out.println(r.getIdPengaduan() + " | " + r.getNamaPelapor() + " | Status: " + r.getStatus() + " | Tanggapan: " + (r.getIsiTanggapan() == null ? "-" : r.getIsiTanggapan()));
                            }
                        }
                        break;

                    case 3:
                        kembali = true;
                        break;
                    default:
                        System.out.println("pilihan tidak valid, coba lagi");
                }
            }
            catch(InputMismatchException e){
                System.out.println("input harus berupa angka");
                sc.next();
            }
        }
    }
}
