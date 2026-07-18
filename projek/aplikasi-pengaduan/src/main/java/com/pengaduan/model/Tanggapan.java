package com.pengaduan.model;

import java.sql.Timestamp;

public class Tanggapan {
    private int idTanggapan;
    private int idPengaduan;
    private String isiTanggapan;
    private Timestamp tanggalTanggapan;

    //Contructor 1
    public Tanggapan(int idTanggapan, int idPengaduan, String isitanggapan, Timestamp tanggalTanggapan){
        this.idTanggapan = idTanggapan;
        this.idPengaduan = idPengaduan;
        this.isiTanggapan = isitanggapan;
        this.tanggalTanggapan = tanggalTanggapan;
    }

    //Contructor 2
    public Tanggapan(int idPengaduan, String isiTanggapan){
        this.idPengaduan = idPengaduan;
        this.isiTanggapan = isiTanggapan;
    }

    //GETTER
    public int getIdTanggapan(){
        return idTanggapan;
    }
    public int getIdPengaduan(){
        return idPengaduan;
    }
    public String getIsiTanggapan(){
        return isiTanggapan;
    }
    public Timestamp getTanggalTanggapan(){
        return tanggalTanggapan;
    }

    //SETTER
    public void setIdTanggapan(int idTanggapan){
        this.idTanggapan = idTanggapan;
    }
    public void setIdPengaduan(int idPengaduan){
        this.idPengaduan = idPengaduan;
    }
    public void setIsiTanggapan(String isiTanggapan){
        this.isiTanggapan = isiTanggapan;
    }
    public void setTanggalTanggapan(Timestamp tanggaltanggapan){
        this.tanggalTanggapan = tanggaltanggapan;
    }
}
