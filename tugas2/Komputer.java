public class Komputer { //1.  deklarasi class Komputer — blueprint yang akan dipakai untuk mencetak object.
    String jenis_komputer; //2. atribut dengan string jenis_komputer berupa teks,
    private String merk; //2. atribut merek berupa teks tapi privat. atribut ini hanya bisa diakses dari dalam class itu sendiri

    public void setDataKomputer(String jenis, String merk) { //3. Setter Method setDataKomputer adalah method setter yang bertugas mengisi atribut class dengan data yang dikirim dari luar
        jenis_komputer = jenis; //3.  Parameter jenis dan merk dimasukkan ke dalam atribut jenis_komputer dan 
        this.merk = merk;//3. this.merk milik class.
    }                               

    public String getJenis() { //4. mengambbil atribut jenis denagn method getter
        return jenis_komputer; //4. Return Statement, return jenis_komputer bertugas mengembalikan nilai atribut jenis_komputer ke tempat yang memanggil method getJenis() atau mengembalikan nilai dengan nilai balikan jenis_komputer
    }

    public String getMerk() { //5. mengambil atribut merek dengan method getter
        return merk; //5. Return Statement, return merk mengembalikan nilai atribut merk ke tempat yang memanggil method getMerk()
    }

    public static void main(String[] args) {
        Komputer mykom = new Komputer(); //6. Pembuatan Object, new Komputer() adalah proses mencetak/membuat object baru dari class Komputer, dan hasilnya disimpan ke dalam variabel mykom
        mykom.setDataKomputer("LAPTOP", "MACBOOK"); //7.  Pemanggilan Setter, mykom.setDataKomputer("LAPTOP", "MACBOOK") memanggil method setter untuk mengisi atribut jenis_komputer dengan nilai "LAPTOP" dan atribut merk dengan nilai "MACBOOK" ke dalam object mykom
        System.out.println(mykom.getJenis()); //8. mencetak hasil ke layar. mykom.getJenis() mengembalikan nilai "LAPTOP" 
        System.out.println(mykom.getMerk()); //8. mencetak hasil ke layar. mykom.getMerk() mengembalikan nilai "MACBOOK",
    }
}

//OUTPUT YANG DIHASILKAN:
//LAPTOP
//MACBOOK