public class BankBNI extends Bank {
    public BankBNI(){
        // super("BCA") → memanggil constructor parent (Bank)
        // untuk mengisi atribut namabank yang ada di parent
        // tanpa ini, namabank bisa jadi "Bank" (default)
        super ("BNI");
    }
    // OVERRIDING
    // method ini menggantikan method di parent
    // dipakai kalau ingin beda perilaku (contoh: suku bunga beda tiap bank, menambah "Transfer via BNI")
    @Override
    public void sukuBunga(){
        System.out.println("Suku Bunga dari BNI adalah 4%");
    }

    @Override
    public void transferUang(int jumlah, String rekeningTujuan, String bankTujuan){
        System.out.println("Transfer via BNI");
        super.transferUang(jumlah, rekeningTujuan, bankTujuan);
    }

}
