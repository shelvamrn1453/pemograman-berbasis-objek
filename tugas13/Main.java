import java.sql.*;
import java.util.Scanner;

public class Main {
    private static final String URL = "jdbc:mysql://localhost:3306/toko_retail";
    private static final String USER = "root";
    private static final String PASSWORD = ""; 
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean berjalan = true;
        while (berjalan) {
            System.out.println("\n=================================");
            System.out.println("        MENU TOKO RETAIL        ");
            System.out.println("=================================");
            System.out.println("1. Tampil Semua Data");
            System.out.println("2. Tambah Data");
            System.out.println("3. Cari Data");
            System.out.println("4. Ubah Data");
            System.out.println("5. Hapus Data");
            System.out.println("0. Keluar");
            System.out.print("Pilihan : ");
            
            int pilihan = scanner.nextInt();
            scanner.nextLine(); // Membersihkan buffer

            switch (pilihan) {
                case 1 -> tampilSemuaData();
                case 2 -> tambahData();
                case 3 -> cariData();
                case 4 -> ubahData();
                case 5 -> hapusData();
                case 0 -> {
                    System.out.println("Aplikasi keluar. Terima kasih!");
                    berjalan = false;
                }
                default -> System.out.println("Pilihan tidak valid!");
            }
        }
    }

    // 1. TAMPIL SEMUA DATA
    private static void tampilSemuaData() {
        String query = "SELECT * FROM barang";
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            System.out.println("\n+-------------------------------------------------------+");
            System.out.println("|               DAFTAR BARANG TOKO RETAIL               |");
            System.out.println("+------+--------+----------------------+---------+------+");
            System.out.printf("| %-4s | %-6s | %-20s | %-7s | %-4s |\n", "#", "Kode", "Nama Barang", "Harga", "Stok");
            System.out.println("+------+--------+----------------------+---------+------+");

            int no = 1;
            while (rs.next()) {
                System.out.printf("| %-4d | %-6s | %-20s | %-7d | %-4d |\n",
                        no++,
                        rs.getString("id"),
                        rs.getString("nama_barang"),
                        rs.getInt("harga"),
                        rs.getInt("stok"));
            }
            System.out.println("+------+--------+----------------------+---------+------+");
            System.out.println("Total: " + (no - 1) + " barang");

        } catch (SQLException e) {
            System.out.println("Gagal memuat data: " + e.getMessage());
        }
    }

    // 2. TAMBAH DATA
    private static void tambahData() {
        System.out.print("Masukkan ID/Kode Barang: ");
        String id = scanner.nextLine();
        System.out.print("Masukkan Nama Barang   : ");
        String nama = scanner.nextLine();
        System.out.print("Masukkan Harga         : ");
        int harga = scanner.nextInt();
        System.out.print("Masukkan Stok          : ");
        int stok = scanner.nextInt();

        String query = "INSERT INTO barang (id, nama_barang, harga, stok) VALUES (?, ?, ?, ?)";
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            
            pstmt.setString(1, id);
            pstmt.setString(2, nama);
            pstmt.setInt(3, harga);
            pstmt.setInt(4, stok);
            pstmt.executeUpdate();
            System.out.println("Data barang berhasil ditambahkan!");

        } catch (SQLException e) {
            System.out.println("Gagal menambah data: " + e.getMessage());
        }
    }

    // 3. CARI DATA
    private static void cariData() {
        System.out.print("Masukkan ID/Kode atau Nama Barang yang dicari: ");
        String keyword = scanner.nextLine();

        String query = "SELECT * FROM barang WHERE id = ? OR nama_barang LIKE ?";
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            
            pstmt.setString(1, keyword);
            pstmt.setString(2, "%" + keyword + "%");
            ResultSet rs = pstmt.executeQuery();

            System.out.println("\n--- Hasil Pencarian ---");
            while (rs.next()) {
                System.out.printf("ID: %s | Nama: %s | Harga: %d | Stok: %d\n",
                        rs.getString("id"), rs.getString("nama_barang"), rs.getInt("harga"), rs.getInt("stok"));
            }

        } catch (SQLException e) {
            System.out.println("Gagal mencari data: " + e.getMessage());
        }
    }

    // 4. UBAH DATA
    private static void ubahData() {
        System.out.print("Masukkan ID/Kode Barang yang ingin diubah: ");
        String id = scanner.nextLine();
        System.out.print("Masukkan Nama Baru  : ");
        String nama = scanner.nextLine();
        System.out.print("Masukkan Harga Baru : ");
        int harga = scanner.nextInt();
        System.out.print("Masukkan Stok Baru  : ");
        int stok = scanner.nextInt();

        String query = "UPDATE barang SET nama_barang = ?, harga = ?, stok = ? WHERE id = ?";
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            
            pstmt.setString(1, nama);
            pstmt.setInt(2, harga);
            pstmt.setInt(3, stok);
            pstmt.setString(4, id);
            
            int rows = pstmt.executeUpdate();
            if (rows > 0) {
                System.out.println("Data barang berhasil diperbarui!");
            } else {
                System.out.println("Barang dengan ID tersebut tidak ditemukan.");
            }

        } catch (SQLException e) {
            System.out.println("Gagal mengubah data: " + e.getMessage());
        }
    }

    // 5. HAPUS DATA
    private static void hapusData() {
        System.out.print("Masukkan ID/Kode Barang yang ingin dihapus: ");
        String id = scanner.nextLine();

        String query = "DELETE FROM barang WHERE id = ?";
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            
            pstmt.setString(1, id);
            int rows = pstmt.executeUpdate();
            if (rows > 0) {
                System.out.println("Data barang berhasil dihapus!");
            } else {
                System.out.println("Barang dengan ID tersebut tidak ditemukan.");
            }

        } catch (SQLException e) {
            System.out.println("Gagal menghapus data: " + e.getMessage());
        }
    }
}