import java.io.*;

class Soal10_RandomAccessRevisi{
    public static void main(String[] args) {
        String bookList[]={"Satu","Dua","Tiga"};
        int yearList[]={1920,1230,1940};
        try{
            RandomAccessFile books = new RandomAccessFile("books.txt","rw");
            for(int i=0;i<3;i++){
                books.writeUTF(bookList[i]);
                books.writeInt(yearList[i]);
            }
            books.seek(0);
            System.out.println(books.readUTF()+" "+books.readInt());
            System.out.println(books.readUTF()+ " "+books.readInt());
            System.out.println(books.readUTF()+" "+books.readInt()); // tambah Data 3
            System.out.println(books.readUTF()+" "+books.readInt()); // tambah Data 4 (Tidak ada!)
            books.close();
        }
        catch(IOException e){
            System.out.println("Indeks melebihi batas");
        }
        System.out.println("test");
    }
}

/* output awal
PS C:\TUGASKULIAH\semester4\tugas10> java Soal10_RandomAccessRevisi                             
Satu 1920                         
Dua 1230
test

outputsetelah ditambah
PS C:\TUGASKULIAH\semester4\tugas10> java Soal10_RandomAccessRevisi      
Satu 1920
Dua 1230
Tiga 1940
Indeks melebihi batas
test
 */