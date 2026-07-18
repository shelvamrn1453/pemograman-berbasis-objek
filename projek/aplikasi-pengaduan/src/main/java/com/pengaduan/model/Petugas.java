package com.pengaduan.model;

public class Petugas extends User{
    private String idPetugas;

    //CONTRUCTOR
    public Petugas(String nama, String username, String password, String idPetugas){
        super(nama, username, password);
        this.idPetugas = idPetugas;
    }

    //GETTER
    public String getIdPetugas(){
        return idPetugas;
    }
    //SETTER
    public void setIdPetugas(String idPetugas){
        this.idPetugas = idPetugas;
    }

    @Override
    public void tampilMenu(){
        System.out.println("===APLIKAIS MANAJEMEN PENGADUAN MASYARAKAT===");
        System.out.println("1. Kelola Pengaduan");
        System.out.println("2. kelola Tanggapan");
        System.out.println("3. Keluar");
    }
}
