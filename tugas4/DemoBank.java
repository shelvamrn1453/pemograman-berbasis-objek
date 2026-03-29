public class DemoBank {
    public static void main(String[] args) {
        // membuat object dari class
        // BNI & BCA punya nilai namabank berbeda karena constructor + super()
        Bank b = new Bank("Bank");
        BankBNI BNI = new BankBNI();
        BankBCA BCA = new BankBCA();

        System.out.println("===TES BAK===");
        b.transferUang(20000, "123");
        b.transferUang(30000, "456" , "BNI");
        b.transferUang(40000, "789", "BCA", "bayar hutang");
        b.sukuBunga();
        System.out.println();

        System.out.println("===TES BANK BNI===");
        BNI.transferUang(50000, "135", "BNI");
        BNI.sukuBunga();
        System.out.println();

        System.out.println("===TES BANK BCA===");
        BCA.transferUang(60000, "246", "BNI");
        BCA.sukuBunga();
    }
}
