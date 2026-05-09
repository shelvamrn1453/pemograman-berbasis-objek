package Model;

public class Amigurumi extends ProdukRajutan {
    private int tinggiCm;
    private String jenisIsi;

    public Amigurumi(String kode, String nama, String bahan, double hargaDasar, int stok, int tinggiCm, String jenisIsi){
        super(kode, nama, bahan, hargaDasar, stok);
        this.tinggiCm = tinggiCm;
        this.jenisIsi = jenisIsi;
    }
    @Override
    public double hitungHargaAkhir(){
        return getHargaDasar() + (tinggiCm * 500); //harga naik per cm
    }
    @Override
    public String tampilkanInfo(){
        return "Amigurumi | " + getNama() + " | Tinggi: " + tinggiCm + "cm | Isi: " + jenisIsi;
    }
}
