public class Main {
    public static void main(String[] args) {
        BankAccount shelva = new BankAccount(1000000, "8790094922", "shelva");
        shelva.deposit(5000000);
        shelva.withdraw(500000);
        System.out.println(shelva);
    }
}
