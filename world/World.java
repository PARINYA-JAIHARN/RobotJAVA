package world;

import java.awt.*;
import javax.swing.*;
import barrier.*;
import java.util.Random; 

public class World
{
    static int row = 10;
    static int column = 10;
    static int rancol ;
    static int ranrow ;
    static int n = 30;
    static int rancol1 ;
    static int ranrow1 ;
    static int rancolTarget ;
    static int ranrowTarget ;

    World[][] world;
    static Barrier[] barrier;

    Robot robot;
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
        barrier = new Barrier[n];
        for(int i= 0; i < n; i++){
            rancol = new Random().nextInt(10) ;
            ranrow = new Random().nextInt(10) ;
            rancol1 = Math.round(rancol);
            ranrow1 = Math.round(ranrow);
            barrier[i] = new Barrier(rancol1, ranrow1, n, n);
            System.out.println(rancol1 + " " + ranrow1);
            //barrier[i].add(new Drawing(barrier[i].getXpoint(), barrier[i].getYpoints(), 4));
            map[5].add(new Drawing(barrier[i].getXpoint(), barrier[i].getYpoints(), 4));
        }
        

        frame.setVisible(true);
    }
}

class Drawing extends JComponent{
    int[] x;
    int[] y;
    int n; // npoint

    Drawing(int[] xpoint, int[] ypoint, int num){
        x = xpoint;
        y = ypoint;
        n = num;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.BLUE);
        g.fillPolygon(x, y, n);
    }
}
