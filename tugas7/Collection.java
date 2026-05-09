import java.util.ArrayList;
import java.util.List;
import java.util.ArrayDeque;

public class Collection {
    public static void main(String[] args) {
        System.out.println("== ArrayList ==");
        List<String> dataMahasiswa = new ArrayList<>();
        dataMahasiswa.add("12345");
        dataMahasiswa.add("Yuki");
        dataMahasiswa.add("22");

        System.out.println("ArrayList : " + dataMahasiswa);

        System.out.println("\n== ArrayDeque ==");
        ArrayDeque<Integer> angka = new ArrayDeque<>();
        angka.add(10);
        angka.add(20);
        angka.add(30);
        System.out.println("ArrayDeque : " + angka);
        System.out.println("Ambil depan : " + angka.peek());
    }
}
