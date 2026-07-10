class Tabungan {
    double saldo; // tidak diencapsulation

    void tambah(double jumlah){
        saldo += jumlah;
    }
    void ambil(double jumlah){
        saldo -= jumlah;
    }
    void infoSaldo(double jumlah){
        System.out.println("saldo: " + saldo);
    }
}

public class Contoh {

    public static void main(String[] args) {
        Tabungan shelva = new Tabungan();
        //shleva.saldo = -1000000; //bisa diubah langsung
        //shelva.saldo = -1000000;
        shelva.tambah(1000000); //diubah melalui method setter
        shelva.ambil(5000);
        shelva.infoSaldo(0);
    }
}
