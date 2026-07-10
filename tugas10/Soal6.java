/* public class Soal6 {
    static void demo(){
        NullPointerException t;
        t=new NullPointerException("Coba Throw");
        throw t;

        // Baris ini tidak lagi dikerjakan;
        System.out.println("Ini tidak lagi dicetak");
    }
    public static void main(String[] args) {
        try{
            demo();
            System.out.println("Selesai");
        }
        catch(NullPointerException e){
            System.out.println("Ada pesan error: "+e);
        }
    }
} */

// Di Java, perintah throw akan langsung menghentikan jalannya metode saat itu juga dan melempar errornya keluar. 
// Akibatnya, perintah System.out.println di bawahnya tidak akan pernah bisa dijangkau oleh komputer (unreachable code). 
// Java melarang keras adanya kode yang mubazir seperti ini.

public class Soal6 {
    static void demo() {
        NullPointerException t;
        t = new NullPointerException("Coba Throw");
        throw t; // Error dilempar di sini step 3

        // Baris di bawah ini dihapus/dikomentari karena menyebabkan error "unreachable code"
        // System.out.println("Ini tidak lagi dicetak");
    }

    public static void main(String[] args) { //dari main playe1 step 1
        try {
            demo();// pindah sini player 2 step 2
            System.out.println("Selesai");
        } 
        catch (NullPointerException e) {
            System.out.println("Ada pesan error: " + e);//lalu jadi ini yg keluar step 4
        }
    }
}