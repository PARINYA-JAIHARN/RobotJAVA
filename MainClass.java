import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.*;
import java.io.*;
import java.security.PublicKey;
import java.util.*;


public class MainClass {
    public static void main(String[] args) {
       World world = new World();
       //Barrier barrier = new Barrier();
       //barrier.setVisible(true);

    }
 }

class World extends JFrame{
    public static int ncolumn;
    public static int nrow;
    public static Barrier barrier;
    public Scanner map;
    public static HashMap<String, String> mapBarrier = new HashMap<String, String>();

    public World(){
        super("Robot Game");
        setBounds(0,0, 1000, 1000);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        Container myContentPane = getContentPane();
        myContentPane.add(new Barrier());

        this.readMap("Map.txt");
    }
    public void readMap(String fileName){
        File file = new File(fileName);
        try 
        {
            map = new Scanner(file); 
            while (map.hasNextLine()){
                String nextLine = map.nextLine();
                if (nextLine.length() > 3 && nextLine.substring(0,4).equalsIgnoreCase("Rows")){
                    nrow = Integer.parseInt(nextLine.split(":")[1]);
                }
                else if (nextLine.length() > 7 && nextLine.substring(0,7).equalsIgnoreCase("Columns")){
                    ncolumn = Integer.parseInt(nextLine.split(":")[1]);
                }
                else if (nextLine.equalsIgnoreCase("BarrierPosition:")){

                    nextLine = map.nextLine();
                    mapBarrier.put(nextLine.substring(1, nextLine.length()-1), "BLOCK");
                }
                else if (nextLine.equalsIgnoreCase("END")){
                    System.out.println(mapBarrier);
                    break;
                }
                else{
                    mapBarrier.put(nextLine.substring(1, nextLine.length()-1), "BLOCK");
                }
            }
            map.close();
        }
        catch (FileNotFoundException e){
            System.out.println("File not found.");
        }

    }

    public static void writhMap(){
        try {

            FileWriter save = new FileWriter("Maps.txt");
            save.write("Rows:" + Integer.toString(nrow)+"\n");
            save.write("Columns:"+ Integer.toString(ncolumn)+"\n");
            save.write("BarrierPosition:\n");

            for (String key : mapBarrier.keySet() ) {
                save.write("("+key+")\n");
            }
            save.write("END");

            save.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

    }
}

class Barrier extends JPanel{
    public int row;
    public int column;

    public Barrier(/*int r, int c*/){
        //row = r;
        //column = c;
    }
    public void paintComponent (Graphics barrier) {
        super.paintComponent(barrier);
        for(int i = 0; i < 11; i++){
            barrier.drawLine(0, i*100, 1000, i*100);
            barrier.drawLine(i*100, 0, i*100, 1000);
        }
        //barrier.drawRect(column, row, 100, 100);
    }    
}

class Robot extends JPanel{
    public int column = 0;
    public int row = 0;
    public int[] pntx;
    public int[] pnty;

    public void paintComponent (Graphics robot) {
        super.paintComponent(robot);
    }
    
}

/*class Target extends JPanel{
    public float column;
    public float row;

    public void paintComponent (Graphics target) {
        super.paintComponent(target);
        
        target.fillOval((((2*column)+1)/2)*100,(((2*row)+1)/2)*100, 80, 80);
        
    }
}*/