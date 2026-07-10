import java.awt.*;
import javax.swing.*;

public class MyForm2 extends JFrame {
    JButton b1 = new JButton("Tombol 1");
    JButton b2 = new JButton("Tombol 2");
    JButton b3 = new JButton("Tombol 3");
    JButton b4 = new JButton("Tombol 4");
    JButton b5 = new JButton("Tombol 5");
   
    MyForm2() {
        super("belajar GUI");
        setSize(400, 200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        getContentPane().setBackground(Color.GRAY);
        setLocationRelativeTo(null);
        FlowLayout f1 = new FlowLayout(FlowLayout.CENTER); // disini yg diganti untuk left or right or center
        setLayout(f1);
        add(b1);
        add(b2);
        add(b3);
        add(b4);
        add(b5);
        setVisible(true);
    }
    public static void main(String[] args) {
        MyForm2 form = new MyForm2();
    }
}
