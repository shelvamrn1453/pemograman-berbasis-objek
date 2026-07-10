import java.io.*;

public class Soal8 {
    public void methodA(){// dijalankan lancar
        System.out.println("Method A");// lalu mencetak Method A
    }
    public void methodB() throws IOException{// dari sini
        System.out.println(20/0);// Di dalam methodB(), komputer menabrak operasi pembagian dengan nol (20 / 0). Error ArithmeticException langsung tercipta.
        System.out.println("Method B");
    }
}

/* class Utama{
    public static void main(String[] args) throws IOException{
        Soal8 c=new Soal8();
        c.methodA();
        c.methodB();
    }
} */
//Kemudian coba ubah class utama diatas dengan yang program baru di bawah ini:

class Utama{
    public static void main(String[] args){
        Soal8 o=new Soal8();
        o.methodA();
        try{// kesini, Karena methodB() tidak menangkap error itu sendiri, error tersebut dilempar keluar menggunakan mekanisme throws
            o.methodB();// Program masuk ke dalam blok try dan memanggil o.methodB();
        }
        catch(Exception e){// Di kelas Utama, blok catch(Exception e) sudah bersiap siaga. Tumpukan error langsung ditangkap sehingga program tidak crash, melainkan mencetak "Error di Method B"
            System.out.println("Error di Method B");
        }
        finally{// Terakhir, blok finally langsung dieksekusi dan mencetak "Ini selalu dicetak".
            System.out.println("Ini selalu dicetak");
        };
    }
}

/* output
PS C:\TUGASKULIAH\semester4\tugas10> java Utama
Method A
Error di Method B
Ini selalu dicetak 
*/