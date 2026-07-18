package com.pengaduan.dao;

import com.pengaduan.database.DatabaseConnection;
import com.pengaduan.model.Tanggapan;
import com.pengaduan.model.RiwayatPengaduan;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TanggapanDAO {
    public void tambah(Tanggapan tanggapan){
        String query = "INSERT INTO tanggapan (id_pengaduan, isi_tanggapan) VALUES (?, ?)";
        Connection c = DatabaseConnection.getConnection();

        try(PreparedStatement stmt = c.prepareStatement(query)){
            stmt.setInt(1, tanggapan.getIdPengaduan());
            stmt.setString(2, tanggapan.getIsiTanggapan());
            stmt.executeUpdate();

            System.out.println("tanggapan berhasil diberikan");
        }
        catch(SQLException e){
            System.out.println("gagal memberikan tanggapan: " + e.getMessage());
        }
    }

    public List<RiwayatPengaduan> getRiwayat(){
        List<RiwayatPengaduan> daftarRiwayat = new ArrayList<>();
        String query = "SELECT * FROM v_data_pengaduan";

        Connection c = DatabaseConnection.getConnection();

        try(PreparedStatement stmt = c.prepareStatement(query);
            ResultSet rs = stmt.executeQuery()){
                
            while(rs.next()){
                RiwayatPengaduan r = new RiwayatPengaduan(
                    rs.getInt("id_pengaduan"),
                    rs.getString("nama_pelapor"),
                    rs.getString("isi_pengaduan"),
                    rs.getString("status"),
                    rs.getString("isi_tanggapan"),
                    rs.getTimestamp("tanggal_tanggapan")
                );
                daftarRiwayat.add(r);
            }
        }
        catch(SQLException e){
            System.out.println("gagal mengambi riwayat tanggapan: " + e.getMessage());
        }
        return daftarRiwayat;
    }
}
