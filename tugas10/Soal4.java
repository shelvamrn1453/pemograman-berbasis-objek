public class Soal4 {
    public static void main(String[] args) {
        int bil=10;
        String b[]={"a","b","c"};
        try{
            System.out.println(bil/0);// yg akan keluar dari ArithmeticException
            System.out.println(b[3]);// yg akan keluar dari ArrayIndexOutOfBoundsException
            // tidak bisa menjalankan semua hanya satu yg akan dieksekusi yaitu di kondisi pertama saja
        }
        catch(ArithmeticException e){
            System.out.println("Terjadi Aritmatika error");
        }
        catch(ArrayIndexOutOfBoundsException e){
            System.out.println("Melebihi jumlah array");
        }
        catch(Exception e){
            System.out.println("Ini menghandle error yang terjadi");
        }
    }
}