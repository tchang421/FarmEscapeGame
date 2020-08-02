import java.awt.Graphics;
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.io.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.awt.event.*;

public class Flood extends MyFarmPanel {
//FLOOD MECHANIC
   public static void flood()
   {
      for (int r = 1; r < map.length-1; r++)
      {
         for(int c = 1; c < map[0].length-1; c++)
         {
            if (map[r][c].equals("14"))
            {
               int rDir=0;
               int cDir=0;
               int checkDir = (int)(Math.random()*4);  
               int floodDir = (int)(Math.random()*3); 
               if (checkDir == 0)
                  rDir = 1;
               if (checkDir == 1)
                  rDir = -1;
               if (checkDir == 2)
                  cDir = 1;
               if (checkDir == 3)
                  cDir = -1;
                   
               if (map[r+rDir][c+cDir].equals("14"))
                  doFlood(checkDir, floodDir, r, c);  
            }
            
            if (map[r][c].equals("04"))
            {
               map[r][c] = "14";
            }
         }
      }
   }
   //PERFORMS THE FLOOD
   public static void doFlood(int ch, int d, int r, int c)
   {
      for (int w = 0; w<3; w++)
      {
         if (ch != 0)
         {
            if (d == w && !map[r+1][c].equals("14") && map[r+1][c].substring(0,1).equals("0"))
               map[r+1][c] = "04";
         }
         if (ch != 1)
         {
            if (d == w && !map[r-1][c].equals("14") && map[r-1][c].substring(0,1).equals("0"))
               map[r-1][c] = "04";
         }
         if (ch != 2)
         {
            if (d == w && !map[r][c+1].equals("14") && map[r][c+1].substring(0,1).equals("0"))
               map[r][c+1] = "04";
         }
         if (ch != 3)
         {
            if (d == w && !map[r][c-1].equals("14") && map[r][c-1].substring(0,1).equals("0"))
               map[r][c-1] = "04";
         }
      }
   }
}