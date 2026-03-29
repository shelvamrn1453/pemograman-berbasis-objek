public class BankBCA extends Bank{
    public BankBCA(){
        super("BCA");
    }
    // OVERRIDING
    // method ini menggantikan method di parent
    // dipakai kalau ingin beda perilaku (contoh: suku bunga beda tiap bank, menambah "Transfer via BCA")
    @Override
    public void sukuBunga(){
        System.out.println("Suku Bunga dari BCA adalah 4.5%");
    }
    @Override
    public void transferUang(int jumlah, String rekeningTujuan, String bankTujuan){
        System.out.println("Transfer via BCA");
        super.transferUang(jumlah, rekeningTujuan, bankTujuan);
    }
}
