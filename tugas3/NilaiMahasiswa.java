public class NilaiMahasiswa extends Mahasiswa{
    private int nilai;
    private String grade;
    private String status;
    

    public NilaiMahasiswa (String nama, String nim, int nilai){
        super(nama, nim);
        this.nilai = nilai;
        
        if (nilai < 0 || nilai > 100){
            System.out.println("inpu nilai salah");
        }else if(nilai >= 80){
            grade = "A";
            status = "LULUS";
        }else if (nilai >= 70){
            grade = "B";
            status = "LULUS";
        }else if (nilai >= 60){
            grade = "C";
            status = "LULUS";
        }else if (nilai >= 50){
            grade = "D";
            status = "TIDAK LULUS";
        }else{
            grade = "E";
            status = "TIDAK LULUS";
        }
    }
    @Override
    public String getInfo(){
        return super.getInfo() + " | Nilai: " + nilai + " | Grade: " + grade + " | Status " + status;
    }
    public int getNilai(){
        return nilai;
    }   
    public String getGrade(){
        return grade;
    }

}
