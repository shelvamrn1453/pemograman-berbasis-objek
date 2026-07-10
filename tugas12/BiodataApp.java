import javax.swing.*; // Mengimpor komponen GUI Swing (JFrame, JLabel, JTextField, dll)
import java.awt.event.*; // Mengimpor Penangan Aksi/Tombol (ActionListener)

public class BiodataApp {
    public static void main(String[] args) {
        // 1. Membuat Jendela Utama (Frame)
        JFrame frame = new JFrame("Aplikasi Biodata Mahasiswa");
        frame.setSize(450, 550); // Mengatur ukuran jendela (lebar, tinggi)
        frame.setLayout(null); // Menggunakan layout manual (setBounds)
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Menutup program saat tanda X diklik

        // 2. Membuat Komponen Label dan Kotak Input (Bagian Atas)
        JLabel lblHeader = new JLabel("Input Data");
        lblHeader.setBounds(20, 15, 100, 25);
        frame.add(lblHeader);

        JLabel lblNim = new JLabel("NIM");
        lblNim.setBounds(20, 45, 100, 25);
        frame.add(lblNim);

        JTextField txtNim = new JTextField(); // Kotak input NIM
        txtNim.setBounds(140, 45, 260, 25);
        frame.add(txtNim);

        JLabel lblNama = new JLabel("Nama");
        lblNama.setBounds(20, 80, 100, 25);
        frame.add(lblNama);

        JTextField txtNama = new JTextField(); // Kotak input Nama
        txtNama.setBounds(140, 80, 260, 25);
        frame.add(txtNama);

        JLabel lblProdi = new JLabel("Program Studi");
        lblProdi.setBounds(20, 115, 100, 25);
        frame.add(lblProdi);

        JTextField txtProdi = new JTextField(); // Kotak input Program Studi
        txtProdi.setBounds(140, 115, 260, 25);
        frame.add(txtProdi);

        // 3. Membuat Tombol Tampilkan dan Reset
        JButton btnTampilkan = new JButton("Tampilkan");
        btnTampilkan.setBounds(140, 155, 110, 30);
        frame.add(btnTampilkan);

        JButton btnReset = new JButton("Reset");
        btnReset.setBounds(260, 155, 110, 30);
        frame.add(btnReset);

        // 4. Membuat Bagian Output (Bagian Bawah)
        JLabel lblOutput = new JLabel("Output");
        lblOutput.setBounds(20, 200, 100, 25);
        frame.add(lblOutput);

        JTextArea txtOutput = new JTextArea(); // Area teks besar untuk hasil
        txtOutput.setEditable(false); // Mengunci output agar tidak bisa diketik manual oleh user
        
        // Membungkus JTextArea ke dalam JScrollPane agar jika teks panjang bisa di-scroll
        JScrollPane scrollPane = new JScrollPane(txtOutput);
        scrollPane.setBounds(20, 230, 380, 230);
        frame.add(scrollPane);

        // 5. Logika Tombol Tampilkan Saat Diklik
        btnTampilkan.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Mengambil teks yang diketik oleh user di kotak input
                String nim = txtNim.getText();
                String nama = txtNama.getText();
                String prodi = txtProdi.getText();

                // Menyusun format teks biodata yang akan ditampilkan
                String hasil = "========== BIODATA MAHASISWA ==========\n\n" +
                               "NIM            : " + nim + "\n" +
                               "Nama           : " + nama + "\n" +
                               "Program Studi  : " + prodi;

                // Memasukkan teks hasil susunan ke dalam JTextArea (Output)
                txtOutput.setText(hasil);
            }
        });

        // 6. Logika Tombol Reset Saat Diklik
        btnReset.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Mengosongkan semua kotak input teks
                txtNim.setText("");
                txtNama.setText("");
                txtProdi.setText("");
                // Mengosongkan area teks output
                txtOutput.setText(""); 
            }
        });

        // 7. Menampilkan Jendela ke Layar
        frame.setVisible(true);
    }
}