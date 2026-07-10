/* public class soal2 {
    public static void main(String[] args) {
        int i=0;
        String greeting[]={
            "Hello World!",
            "No, I mean it!",
            "Hello World"
        };
        while(i<4)
        {
            System.out.println(greeting[i]);
            i++;
        }
    }
} */

public class Soal2 {
    public static void main(String[] args) {
        int i=0; //i dimulai dari 0
        String greeString[]={
            "Hello World",
            "No, I mean it!",
            "Hello World"
        };
        while(i<4){ //i kurang dari 4 yaitu 0, 1, 2
            try{
                System.out.println(greeString[i]);
                i++;
            }catch(ArrayIndexOutOfBoundsException e){ //ini yg ditambah
                System.out.println("resetting index value");
                i=0;
                break; //ini yg ditambah
            }  
        }
    }
}