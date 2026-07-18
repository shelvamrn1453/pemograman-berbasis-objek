package com.pengaduan.service;

import com.pengaduan.dao.TanggapanDAO;
import com.pengaduan.model.RiwayatPengaduan;
import com.pengaduan.model.Tanggapan;

import java.util.List;

public class TanggapanService {
    private TanggapanDAO tanggapanDAO;

    public TanggapanService(){
        this.tanggapanDAO = new TanggapanDAO();
    }

    public void beriTanggapan(int idPengaduan, String isiTanggapan){
        //validasi input
        if(idPengaduan <= 0){
            System.out.println("id pengaduan tidak valid");
            return;
        }
        if(isiTanggapan == null || isiTanggapan.trim().isEmpty()){
            System.out.println("isi tanggapan tidak boleh kosong");
            return;
        }

        Tanggapan tanggapan = new Tanggapan(idPengaduan, isiTanggapan);
        tanggapanDAO.tambah(tanggapan);
    }
    public List<RiwayatPengaduan> getRiwayat(){
        return tanggapanDAO.getRiwayat();
    }
}
