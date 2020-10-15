package barrier ;

import javax.swing.*;
import java.awt.*;

public class Barrier 
{
    boolean empty = false;
    int ranrow;
    int rancol;
    int[] xpoint = {0,50,0,50};
    int[] ypoint = {0,0,50,50};

    int w;
    int h;
  
    public Barrier(int ranRow, int ranCol, int w, int h){
        this.rancol = ranCol;
        this.ranrow = ranRow;
        this.w = w;
        this.h = h;
    }

    public int getRanCol(){
      return rancol;
    }

    public int getRanRow(){
      return ranrow;
    }

    public int[] getXpoint(){
      return xpoint;
    }

    public int[] getYpoints(){
      return ypoint;
    }
  
}