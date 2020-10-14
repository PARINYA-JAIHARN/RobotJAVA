package world;

import java.awt.*;
import javax.swing.*;

public class World
{
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setSize(500,500);
        frame.setBackground(Color.WHITE);
        
        JPanel main = new JPanel();
        main.setLayout(new GridLayout(10,10,1,1));
        main.setBackground(Color.GRAY);
        frame.add(main);
        
        JPanel[] map = new JPanel[100];
        for (int i=0; i<100; i++){
            map[i] = new JPanel();
            map[i].setBackground(Color.PINK);
            map[i].setBorder(null);
            main.add(map[i]);
        }
        frame.setVisible(true);
    }
}