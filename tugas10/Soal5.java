public class Soal5 {
    public static void main(String[] args) {
        int bil=10;
        try{
            System.out.println(bil/0);
        }
        catch(ArithmeticException e){
            System.out.println("Pesan error: ");
            System.out.println(e.getMessage());// e.getMessage hanya menampilkan pesan error biaya "by zero saja"
            System.out.println("Info stack erase");
            e.printStackTrace();// e.printStackTrace memberi info yg jelas letak salahnya diman yaitu di baris 5
            e.printStackTrace(System.out);
        }
        catch(Exception e){
            System.out.println("Ini menghandle error yang terjadi");
        }
    }
}