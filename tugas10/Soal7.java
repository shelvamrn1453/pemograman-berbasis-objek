public class Soal7 {
    public static void main(String[] args) {
        try{
            throw new Exception("Here's my Exception");
        }
        catch(Exception e){
            System.out.println("Caught Exception");
            System.out.println("e.getMessage():"+e.getMessage());
            System.out.println("e.toString():"+e.toString());
            System.out.println("e.printStackTrace():");
            e.printStackTrace();
        }
    }
}


/* output:
Caught Exception
e.getMessage():Here's my Exception -> Hanya mengambil teks pesan yang kamu tulis di dalam kurung saat membuat exception (new Exception("...")).
e.toString():java.lang.Exception: Here's my Exception -> Ini selangkah lebih lengkap. Dia menggabungkan Nama Kelas Exception-nya (java.lang.Exception) lalu diberi tanda titik dua (:) dan diikuti oleh pesan error-nya.
e.printStackTrace(): -> Ini yang paling lengkap karena memberi tahu di baris mana error itu lahir (yaitu baris nomor 4).
java.lang.Exception: Here's my Exception
        at Soal7.main(Soal7.java:4) 
        
perbedaannya adalah tingkat kelengkapan informasinya: getMessage() hanya pesannya saja, toString() ditambah nama jenis error-nya, dan printStackTrace() ditambah lokasi baris kodenya.   
*/