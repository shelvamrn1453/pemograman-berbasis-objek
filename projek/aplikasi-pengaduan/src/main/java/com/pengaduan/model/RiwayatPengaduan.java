package com.pengaduan.model;

import java.sql.Timestamp;

public class RiwayatPengaduan {
    
    private int idPengaduan;
    private String namaPelapor;
    private String isiPengaduan;
    private String status;
    private String isiTanggapan;
    private Timestamp tanggalTanggapan;
    
    public RiwayatPengaduan(int idPengaduan, String namaPelapor, String isiPengaduan, 
                             String status, String isiTanggapan, Timestamp tanggalTanggapan) {
        this.idPengaduan = idPengaduan;
        this.namaPelapor = namaPelapor;
        this.isiPengaduan = isiPengaduan;
        this.status = status;
        this.isiTanggapan = isiTanggapan;
        this.tanggalTanggapan = tanggalTanggapan;
    }
    
    public int getIdPengaduan() { return idPengaduan; }
    public String getNamaPelapor() { return namaPelapor; }
    public String getIsiPengaduan() { return isiPengaduan; }
    public String getStatus() { return status; }
    public String getIsiTanggapan() { return isiTanggapan; }
    public Timestamp getTanggalTanggapan() { return tanggalTanggapan; }
}