public class Mahasiswa<O, P, Q> {
    private O nim;
    private P name;
    private Q clas;

    public void setNim(O nim){
        this.nim = nim;
    }

    public void setName(P name){
        this.name = name;
    }

    public void setClas(Q clas){
        this.clas = clas;
    }

    public O getNim(){
        return nim;
    }

    public P getName(){
        return name;
    }

    public Q getClas(){
        return clas;
    }

    public static void main(String[] args) {
        Mahasiswa <String, String, Integer> m = new Mahasiswa<>();
        m.setNim("20240040075");
        m.setName("Shelva");
        m.setClas(24);

        System.out.println(m.getNim());
        System.out.println(m.getName());
        System.out.println(m.getClas());
    }
}

