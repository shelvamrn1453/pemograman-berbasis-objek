package app;

import interfaces.Laptop;
import Model.LaptopUser;
import Model.Lenovo;
import Model.Macbook;
import Model.Toshiba;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Buat objek laptop
        Laptop ln = new Lenovo();
        Laptop mac = new Macbook();
        Laptop tosh = new Toshiba();

        // ===== PILIH LAPTOP =====
        System.out.println("=== PILIH LAPTOP ===");
        System.out.println("1. Lenovo");
        System.out.println("2. MacBook");
        System.out.println("3. Toshiba");
        System.out.print("Masukkan pilihan: ");

        int pilihan = scanner.nextInt();
        scanner.nextLine(); // buang enter

        Laptop laptopDipilih;

        switch (pilihan) {
            case 1:
                laptopDipilih = ln;
                break;
            case 2:
                laptopDipilih = mac;
                break;
            case 3:
                laptopDipilih = tosh;
                break;
            default:
                laptopDipilih = mac;
                System.out.println("Pilihan tidak valid, default MacBook");
        }

        LaptopUser shelva = new LaptopUser(laptopDipilih);

        boolean isRunning = true;

        System.out.println("\n=== KONTROL LAPTOP ===");
        System.out.println("Ketik 'ON'   : Menyalakan laptop");
        System.out.println("Ketik 'OFF'  : Mematikan laptop");
        System.out.println("Ketik 'UP'   : Menambah volume");
        System.out.println("Ketik 'DOWN' : Mengurangi volume");
        System.out.println("Ketik 'EXIT' : Keluar dari program");
        System.out.println("======================");

        while (isRunning) {
            System.out.print("\nMasukkan perintah: ");
            String input = scanner.nextLine().toUpperCase();

            switch (input) {
                case "ON":
                    shelva.turnOnlaptop();
                    break;
                case "OFF":
                    shelva.turnOfflaptop();
                    break;
                case "UP":
                    shelva.makeLaptopLouder();
                    break;
                case "DOWN":
                    shelva.makeLaptopSilence();
                    break;
                case "EXIT":
                    System.out.println("Program dihentikan.");
                    isRunning = false;
                    break;
                default:
                    System.out.println("Perintah tidak dikenali.");
            }
        }

        scanner.close();
    }
}