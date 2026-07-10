import java.text.NumberFormat;
import java.util.Locale;

public class BankAccount {
    private double saldo;
    private String AccountNumber;
    private String AccountName;

    public BankAccount (double firstSaldo, String AccountNumber, String AccountName){
        saldo = firstSaldo;
        this.AccountNumber = AccountNumber;
        this.AccountName = AccountName;
    }
    public void deposit (double amount){
        this.saldo += amount;
    }
    public void withdraw (double amount){
        this.saldo -= amount;
    }
    public double getSaldo(){
        return this.saldo;
    }
    public String getAccountNumber(){
        return this.AccountNumber;
    }
    public String getAccountname(){
        return this.AccountName;
    }

    @Override
    public String toString(){
        @SuppressWarnings("deprecation")
        NumberFormat format = NumberFormat.getInstance(new Locale("id","ID"));
        return "Account Number : " + this.AccountNumber + 
                "\nAccount name : " + this.AccountName +
                "\nSaldo : " + format.format(this.saldo);
    }
}
