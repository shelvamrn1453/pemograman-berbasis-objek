package Main;

import Model.Amigurumi;
import Model.Pelanggan;
import Model.Sweater;
import Service.TokoRajutService;

public class Main {
    public static void main(String[] args) {
        TokoRajutService toko = new TokoRajutService();

        Sweater s1 = new Sweater("S01", "sunflower Cardigan",   "milk cotton",150000,  1, "L");
        s1.setDetailCustom("tambah inisial huruf A"); //implementasi interface

        Amigurumi bunny = new Amigurumi("A01", "Bunny Carrot", "milk cotton", 45000, 5, 15, "Dacron");
        Sweater s2 = new Sweater("S02", "Daisy Cardigan", "Polyester", 120000, 1, "XL");

        toko.tambahProduk(s1);
        toko.tambahProduk(bunny);
        toko.tambahProduk(s2);
        toko.tambahpelanggan(new Pelanggan("P01", "Shelva", "087725082004"));

        toko.cetakKatalog();

         Pelanggan hasil = toko.cariPelanggan("Shelva"); 
        if (hasil != null) {
            System.out.println("\nPelanggan Aktif: " + hasil.getNama());
        }
    }
}
