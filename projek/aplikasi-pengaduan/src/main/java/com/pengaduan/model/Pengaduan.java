package com.pengaduan.model;

public class Pengaduan {
    private int idPengaduan;
    private String namaPelapor;
    private String isiPengaduan;
    private String status;

    //Constructor lengkap (dipakai saat data DIAMBIL dari database, sudah puya id & status)
    public Pengaduan(int idPengaduan, String namaPelapor, String isiPengaduan, String status){
        this.idPengaduan = idPengaduan;
        this.namaPelapor = namaPelapor;
        this.isiPengaduan = isiPengaduan;
        this.status = status;
    }
    //Constructor tanpa id & status (dipakai  saat use BARU mengisi form tambah pengaduan)
    //Constructor overloading
    public Pengaduan(String namaPelapor, String isiPengaduan){
        this.namaPelapor = namaPelapor;
        this.isiPengaduan = isiPengaduan;
    }

    //GETTER
    public int getIdPengaduan(){
        return idPengaduan;
    }public String getNamaPelapor(){
        return namaPelapor;
    }
    public String getIsiPengaduan(){
        return isiPengaduan;
    }
    public String getStatus(){
        return status;
    }

    //SETTER
    public void setIdPengaduan(int idPengaduan){
        this.idPengaduan = idPengaduan;
    }
    public void setNamaPelapor(String namaPelapor){
        this.namaPelapor = namaPelapor;
    }
    public void setIsiPengaduan(String isipengaduan){
        this.isiPengaduan = isipengaduan;
    }
    public void setStatus(String status){
        this.status = status;
    }
}


