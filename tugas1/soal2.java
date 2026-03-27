import java.util.Scanner;

class Belajar{
    String matkul;
    String feedback;

    public Belajar(String inputmatkul){
        this.matkul = inputmatkul;
        this.feedback = " sangat mudah";
    }

    public void tampilkanPesan (){
        System.out.print("belajar " + matkul);
        System.out.print(feedback);
    }
}

//program utama
public class soal2 {
    public static void main(String[] args) {
        java.util.Scanner input = new Scanner(System.in);

        //input user
        System.out.print("anda sedang belajar apa? ");
        String jawabanUser = input.nextLine();

        //objek: hasil cetakan class
        Belajar diajar = new Belajar(jawabanUser);

        //panggil method
        diajar.tampilkanPesan();

        input.close();
    }
    
}
