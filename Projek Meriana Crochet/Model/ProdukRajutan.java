package Model;

public abstract class ProdukRajutan{
    private String kode;
    private String nama;
    private String bahan;
    private double hargaDasar;
    private int stok;

    public ProdukRajutan(String kode, String nama, String bahan, double hargaDasar, int stok){
        this.kode = kode;
        this.nama = nama;
        this.bahan = bahan;
        this.hargaDasar = hargaDasar;
        this.stok = stok;
    }

    public String getKode(){
        return kode;
    }
    public String getNama(){
        return nama;
    }
    public String getBahan(){
        return bahan;
    }
    public double getHargaDasar(){
        return hargaDasar;
    }
    public int getStok(){
        return stok;
    }
    public void setStok(int stok){
        if(stok >= 0){
            this.stok = stok;
        }     
    }

    public abstract double hitungHargaAkhir();
    public abstract String tampilkanInfo();
}