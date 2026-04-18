package src;
import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class Main{

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setTitle("Rush Bot Royal!");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setSize(600,600);
        frame.setVisible(true);

        ImageIcon image = new ImageIcon("cartoon.png");
        frame.setIconImage(image.getImage());
        frame.getContentPane().setBackground(new Color(123,50,250));
    }
}