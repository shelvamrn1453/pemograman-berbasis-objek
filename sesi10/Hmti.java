public class Hmti {
    public static void main(String[] args) {
        MhsInformatika mhs = new MhsInformatika("A", null);
    try{
        System.out.println(mhs.getNama());
        System.out.println(mhs.getNim());
    }
    catch(NullPointerException npe){
        System.out.println("nim belum ad isinya");
    }
    finally{
        System.out.println("program selesai");
    }
}
