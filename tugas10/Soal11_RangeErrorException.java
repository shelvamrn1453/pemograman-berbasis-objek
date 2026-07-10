class Soal11_RangeErrorException extends Throwable{//program membuat sebuah kelas baru bernama RangeErrorException yang menjadi anak (extends) dari Throwable. 
// Artinya, kita bisa menentukan sendiri kapan suatu kondisi dianggap sebagai "error" sesuai kebutuhan aplikasi kita.
    public Soal11_RangeErrorException(String s){
        super(s);
    }

    public static void main(String[] args){
        int position=1;
        try{
            if(position>0){// Masuk ke blok try, komputer memeriksa kondisi if (position > 0). Karena 1 > 0 bernilai benar (true), program menjalankan perintah di dalamnya.
                throw new Soal11_RangeErrorException("Position " +position);// ini dieksekusi, program mengirim error sambil mngirim pesan "Positioon 1"
            }
        }
        catch(Soal11_RangeErrorException e){
            System.out.println("Range error: " +e.getMessage());// program mencetak "Range error: " digabung dengan isi dari e.getMessage(). jadi "Rage error: Position 1"
        }
        System.out.println("This is the last program.");// ini tetap si eksekusi
    }
}

/* output
PS C:\TUGASKULIAH\semester4\tugas10> java Soal11_RangeErrorException
Range error: Position 1
This is the last program. 
*/