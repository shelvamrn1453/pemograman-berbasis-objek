package com.pengaduan.service;

import com.pengaduan.dao.PengaduanDAO;
import com.pengaduan.model.Pengaduan;

import java.util.List;

public class PengaduanService {
    private PengaduanDAO pengaduanDAO;

    public PengaduanService(){
        this.pengaduanDAO = new PengaduanDAO();
    }
    public void tambahPengaduan(String namaPelapor, String isiPengaduan){
        //validasi input
        if(namaPelapor == null || namaPelapor.trim().isEmpty()){
            System.out.println("nama pelapor tidak boleh kosong!");
            return;
        }
        if (isiPengaduan == null || isiPengaduan.trim().isEmpty()){
            System.out.println("isi pengaduan tidak boleh kosong!");
            return;
        }

        //kalau lolos validasi, baru diteruskan ke DAO
        Pengaduan pengaduan = new Pengaduan(namaPelapor, isiPengaduan);
        pengaduanDAO.tambah(pengaduan);
    }

    public List<Pengaduan> getAllPengaduan(){
        return pengaduanDAO.getAll();
    }

    public int getTotalPengaduan(){
        return pengaduanDAO.getTotalPengaduan();
    }

    //UPDATE
    public void updatePengaduan(int idPengaduan, String isiPengaduanBaru){
        //validasi input
        if(isiPengaduanBaru == null || isiPengaduanBaru.trim().isEmpty()){
            System.out.println("nama pelapor tidak boleh kosong!");
            return;
        }

        //kalau lolos validasi, baru diteruskan ke DAO
        pengaduanDAO.update(idPengaduan, isiPengaduanBaru);
    }

    //DELETE
    public void hapusPengaduan(int idPengaduan){
        pengaduanDAO.hapus(idPengaduan);
    }
}
