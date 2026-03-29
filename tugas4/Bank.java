//SUPER CLASS
public class Bank{
    protected String namabank;

    //CONSTRUCTOR
    public Bank(String namabank){
        this.namabank = namabank;
    }
    // hitung biaya admin berdasarkan bank tujuan
    // kalau bank asal (namabank) sama dengan bank tujuan → gratis
    // kalau beda → kena biaya 6500
    protected int hitungAdmin (String bankTujuan){
        if (namabank.equals(bankTujuan)){
            return 0;
        }else{
            return 6500;
        }
    }

    //OVERLOADING
    public void transferUang(int jumlah, String rekeningTujuan){
        System.out.println("Transfer Rp. " + jumlah + " | ke nomor rekening " + rekeningTujuan);
    }
    public void transferUang(int jumlah, String rekeningTujuan, String bankTujuan){
        int admin =hitungAdmin(bankTujuan);
        System.out.println("Transfer Rp. " + jumlah + " | ke nomor rekening " + rekeningTujuan + " | bank " + bankTujuan + " | admin " + admin);
    }
    public void transferUang(int jumlah, String rekeningTujuan, String bankTujuan, String berita){
        int admin = hitungAdmin(bankTujuan);
        System.out.println("Transfer Rp. " + jumlah + " | ke nomor rekening "+ rekeningTujuan + " | bank " + bankTujuan + " | keterangan " + berita + " | admin " + admin);
    }
    public void sukuBunga(){
        System.out.println("Suku Bunga Standar adalah 3%");
    }
}