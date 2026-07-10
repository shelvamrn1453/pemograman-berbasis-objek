/* public class Exception3 {
    public static void main(String[] args) {
        int bil=10;
        System.out.println(bil/0);
    }
} */

public class Soal3 {
    public static void main(String[] args) {
        int bil=10;
        try{
            System.out.println(bil/0);
        }catch (ArithmeticException e){//ini yg ada ti tampilkan duluan
            System.out.println("Aritmatika salah, tidak bisa membagi dengan nol");
        }catch(Exception e){
            System.out.println("ini menghandle error yg terjasi");
        }
    }
}