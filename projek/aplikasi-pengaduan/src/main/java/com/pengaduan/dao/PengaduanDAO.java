package com.pengaduan.dao;

import com.pengaduan.database.DatabaseConnection;
import com.pengaduan.model.Pengaduan;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PengaduanDAO {

    // Method tambah() dengan koneksi yang tetap ter-maintain (Singleton)
    public void tambah(Pengaduan pengaduan) {
        String query = "CALL tambah_pengaduan(?, ?)";
        Connection c = DatabaseConnection.getConnection(); // Koneksi diambil di luar try

        try (CallableStatement stmt = c.prepareCall(query)) {
            stmt.setString(1, pengaduan.getNamaPelapor());
            stmt.setString(2, pengaduan.getIsiPengaduan());
            stmt.execute();

            System.out.println("Pengaduan berhasil ditambahkan.");

        } catch (SQLException e) {
            System.out.println("Gagal menambahkan pengaduan: " + e.getMessage());
        }
    }

    // Method getAll() perbaikan: conn di luar try-with-resources
    public List<Pengaduan> getAll() {
        List<Pengaduan> daftarPengaduan = new ArrayList<>();
        String query = "SELECT * FROM pengaduan";
        
        // 1. Ambil koneksi di luar try-with-resources agar TIDAK ter-close otomatis
        Connection c = DatabaseConnection.getConnection();

        // 2. Hanya PreparedStatement & ResultSet yang di auto-close oleh try-with-resources
        try (PreparedStatement stmt = c.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Pengaduan p = new Pengaduan(
                    rs.getInt("id_pengaduan"),
                    rs.getString("nama_pelapor"),
                    rs.getString("isi_pengaduan"),
                    rs.getString("status")
                );
                daftarPengaduan.add(p);
            }

        } catch (SQLException e) {
            System.out.println("Gagal mengambil data pengaduan: " + e.getMessage());
        }

        return daftarPengaduan;
    }

    public int getTotalPengaduan(){
        String query = "SELECT total_pengaduan() AS total";
        Connection c = DatabaseConnection.getConnection();
        int total = 0;

        try(PreparedStatement stmt = c.prepareStatement(query);
            ResultSet rs =stmt.executeQuery()){
            
            if(rs.next()){
                total = rs.getInt("total");
            } 
        }
        catch(SQLException e){
            System.out.println("gagal mengambil total pengaduan: " + e.getMessage());
        }
        return total;
    } 

    //UPSATE - edit isi pengaduan
    public void update(int idPengaduan, String isiPengaduanBaru){
        String query = "UPDATE pengaduan SET isi_pengaduan = ? WHERE id_pengaduan = ?";
        Connection c = DatabaseConnection.getConnection();

        try(PreparedStatement stmt = c.prepareStatement(query)){
            stmt.setString(1, isiPengaduanBaru);
            stmt.setInt(2, idPengaduan);
            int baris = stmt.executeUpdate();

            if (baris > 0){
                System.out.println("pengaduan berhasil diperbarui");
            }
            else{
                System.out.println("ID pengaduan tidak ditemukan");
            }
        }
        catch(SQLException e){
            System.out.println("gagal memperbarui pengaduan: " + e.getMessage());
        }
    }

    //DELETE - hapus pengaduan (tanggapan terkai ikut terhapus via CASSADE)
    public void hapus(int idPengaduan){
        String query = "DELETE FROM pengaduan WHERE id_pengaduan = ?";
        Connection c = DatabaseConnection.getConnection();

        try(PreparedStatement stmt = c.prepareStatement(query)){
            stmt.setInt(1, idPengaduan);
            int baris = stmt.executeUpdate();

            if(baris > 0){
                System.out.println("pengaduan berhasil dihapus");
            }
            else{
                System.out.println("ID pengaduan tidak ditemukan");
            }
        }
        catch(SQLException e){
            System.out.println("gagal meghapus pengaduan: " + e.getMessage());
        }
    }
}