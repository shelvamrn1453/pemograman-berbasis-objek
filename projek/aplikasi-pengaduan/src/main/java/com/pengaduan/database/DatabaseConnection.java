package com.pengaduan.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    // ini "wadah" penyimpanan koneksi, static artinya nempel ke class, bukan ke objek — jadi semua bagian program mengakses variabel yang sama persis, bukan salinan masing-masing
    private static Connection connection = null;

    private static final String URL = "jdbc:mysql://localhost:3306/db_pengaduan";
    private static final String USER = "root";
    private static final String PASSWORD = ""; //isi sesuai password mysql

    //constructor dibuat private, supaya tidak bia "new databaseConnection()" dari luar
    private DatabaseConnection(){
    }

    public static Connection getConnection(){
        try{
            //kalou koneksi blm ada, ATAU koneksi lama sudah tertutup, baru bikin baru
            if(connection == null || connection.isClosed()){
                connection = DriverManager.getConnection(URL, USER, PASSWORD);
                System.out.println(("KOneksi ke database berhasil!"));
            }
        }
        catch(SQLException e){
            System.out.println("koneksi ke database gagal: " + e.getMessage());
        }
        return connection;
    }
}
