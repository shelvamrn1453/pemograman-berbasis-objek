package Model;

public class Pelanggan {
    private String id;
    private String nama;
    private String kontak;

    public Pelanggan(String id, String nama, String kontak){
        this.id = id;
        this.nama = nama;
        this.kontak = kontak;
    }
    public String getId(){
        return id;
    }
    public String getNama(){
        return nama;
    }
    public String getKontak(){
        return kontak;
    }
}
