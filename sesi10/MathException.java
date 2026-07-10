import java.util.InputMismatchException;
import java.util.Scanner;

public class MathException{
    public static void main(String[] args) {
        
        try{
            Scanner sc = new Scanner(System.in);
            System.out.println("isikan bilangan 1: ");
            int num1 = sc.nextInt();
            System.out.println("isikan bilangan 2: ");
            int num2 = sc.nextInt();
            int result = num1/num2;
            System.out.println("Hasil: " + result);
        }catch(ArithmeticException ae){
            //ae.printStackTrace();
            System.out.println("tidak boleh pembagian dengan 0");
        }catch(InputMismatchException ime){
            System.out.println("isikan hanya angka");
        }
        finally{
            System.out.println("finally akan selalu dikerjakan");
        }
    }
}