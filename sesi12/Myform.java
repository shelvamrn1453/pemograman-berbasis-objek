import java.awt.*;
import javax.swing.*;

public class Myform extends JFrame{
    Myform(){
        super("belajar GUI");
        setSize (800, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        getContentPane().setBackground(Color.BLUE);
        setLocationRelativeTo(null);
        setVisible(true);
    }
    public static void main(String[] args) {
        Myform form = new Myform();
    }
}