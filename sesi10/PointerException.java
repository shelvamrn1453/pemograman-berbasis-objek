public class PointerException {
    public static void main(String[] args) {
        
        try{
            String nama = null;
            System.out.println(nama.length());
        }
        catch(Exception e){
            System.out.println("variabel nama harus di inisialisasi");
        }
        finally{
            System.out.println("Null pointer");
        }
        
    }
}
