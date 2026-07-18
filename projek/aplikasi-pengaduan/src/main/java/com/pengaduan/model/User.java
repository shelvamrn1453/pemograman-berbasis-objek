package com.pengaduan.model;


public class User {
    private String nama;
    private String username;
    private String password;

    //CONSTRUCTOR
    public User(String nama, String username, String password){
        this.nama = nama;
        this.username = username;
        this.password = password;
    }

    //GETTER
    public String getNama(){
        return nama;
    }
    public String getUsername(){
        return username;
    }
    public String getPassword(){
        return password;
    }

    //SETTER
    public void setNama(String nama){
        this.nama = nama;
    }
    public void setUsername(String username){
        this.username = username;
    }
    public void setPassword(String password){
        this.password = password;
    }

    public void tampilMenu(){
        System.out.println("===MENU USER===");
        System.out.println("1. Lihat Pengaduan");
        System.out.println("2. Keluar");
    }
}

