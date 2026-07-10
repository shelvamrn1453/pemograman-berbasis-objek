package model;

public abstract class Produk {
    public String nama;
    public int harga;
    public int qty;
    public int stok;

    public abstract int hitungTotal();

    public void tampil(){
        System.out.println("nama  : " + nama);
        System.out.println("harga : " + harga);
        System.out.println("qty   : " + qty);
    }
}
