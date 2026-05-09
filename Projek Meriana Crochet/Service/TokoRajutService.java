package Service;

import java.util.ArrayList;

import Model.Pelanggan;
import Model.ProdukRajutan;

public class TokoRajutService {
    private ArrayList<ProdukRajutan> katalog = new ArrayList<>();
    private ArrayList<Pelanggan> daftarpelanggan = new ArrayList<>();

    public void tambahProduk(ProdukRajutan produk){
        katalog.add(produk); //masukkan data ke list
    }
    public void tambahpelanggan(Pelanggan p){
        daftarpelanggan.add(p);
    }

    public void cetakKatalog(){
        System.out.println("=== KATALOG PRODUK MERIANA CROCHET ===");
        for(int  i = 0; i < katalog.size(); i++){
            ProdukRajutan item = katalog.get(i); //ambil data ke-i

            System.out.println(item.tampilkanInfo());
            System.out.println("Harga akhir: Rp " + (int)item.hitungHargaAkhir());
            System.out.println("---------------------------------------------");
        }
    }

    public Pelanggan cariPelanggan(String cariNama){
        System.out.println("Mencari pelanggan: " + cariNama);

        for (int i=0; i < daftarpelanggan.size(); i++){
            Pelanggan pe = daftarpelanggan.get(i);
            if (pe.getNama().equalsIgnoreCase(cariNama)){
                System.out.println("DITEMUKAN: " + pe.getNama() + " (ID: " + pe.getId() + ")");
                return pe;
            }
        }

        System.out.println("PELANGGAN TIDAK DITEMUKAN!");
        return null;
    }
}
