import javax.swing.JPanel;
import javax.swing.ImageIcon;
import javax.swing.Timer;
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

public class Movement extends MyFarmPanel 
{
   private static int moveVertical = 0;
   private static int moveHorizontal = 0;
   private static int r = 0;
   private static int c = 0;
   

   public static void farmerMove()
   {  
      //MOVEMENT DIRECTION
     // int moveVertical = 0;
     // int moveHorizontal = 0;
      
      //TRAVERSES THROUGH DOUBLE ARRAY OF CHARACTERS
      for (r = 0 ; r < character.length; r++)
      {
         for (c = 0; c < character[0].length; c++)
         {
            //CHECKS IF THE SPACE CONTAINS A FARMER OBJECT
            if (character[r][c] != null && character[r][c].getPlayerType() >= 1)
            {
               boolean datFarmerMove = true;//bolean whether or not farmer can move
               
               //CHECKS THE SPEED OF THE FARMER
               if((character[r][c].getTimeIndex() + 700 - character[r][c].getSpeed()) > System.currentTimeMillis())
                  datFarmerMove = false;
               else
               {
                  long doggyJohaMattTae123 = System.currentTimeMillis();
                  character[r][c].setTimeIndex(doggyJohaMattTae123);
               }
               
               //TURN OFF CHASING IF PLAYER IS CAPUTRED
               if (capturedPlayer != null)
               {
                  character[r][c].setTypeOfMovement(0);
               }
               
               //FARMERS MOVE
               if (datFarmerMove)
               {        
                  //CALLS METHOD WITH TYPE OF MOVEMENT    
                  if (character[r][c].getTypeOfMovement() == 0) 
                     randomMovement();
                  else if (character[r][c].getTypeOfMovement() == 1)
                     chaseMovement();
                  else if (character[r][c].getTypeOfMovement() == 2)
                     marchMovement();
                  
               }
            }
         }
      }
   }
   
   
   //////////////////////////////////////
   //TYPES OF MOVEMENT
   //////////////////////////////////////
   
   public static void randomMovement()
   {
      moveVertical = 0;
      moveHorizontal =0;
      int farmerDirection = (int)(Math.random()*4); 
      if (farmerDirection == 0)//DOWN
         moveVertical = -1; 
      if (farmerDirection == 1)//UP
         moveVertical = 1;
      if (farmerDirection == 2)//RIGHT
         moveHorizontal = -1;
      if (farmerDirection == 3)//LEFT
         moveHorizontal = 1;
                   
      //IF SPACE FARMER WANTS TO WALK ON IS WALKABLE, AND EMPTY   
      doMove(r, c, moveVertical, moveHorizontal, farmerDirection);
   }
   
   public static void chaseMovement()
   {  
      moveVertical = 0;
      moveHorizontal =0;
      int farmerDirection = 0;
      //DIFFERENCE IN POSITIONS
      int verDif =  character[playerR][playerC].getRow() - r;
      int horDif =  character[playerR][playerC].getCol() - c;
      
      //MOVE VERTICAL
      if (Math.abs(verDif) >= Math.abs(horDif))
      {
         if (verDif > 0)
         {
            farmerDirection = 0;
            moveVertical = -1;
         } 
         else
         {
            farmerDirection = 1;
            moveVertical = 1; 
         }
      }
      //MOVE HORIZONTAL
      else
      {
         if (horDif > 0)
         {
            farmerDirection = 2;
            moveHorizontal = -1; 
         }
         else
         {
            farmerDirection = 3;
            moveHorizontal = 1;
         }
      }
      //IF SPACE FARMER WANTS TO WALK ON IS WALKABLE, AND EMPTY   
      doMove(r, c, moveVertical, moveHorizontal, farmerDirection);
   }
   
   public static void marchMovement()
   { 
      int dist = character[r][c].getTempMarchDist();
      int dir = character[r][c].getMarchDir();
      int farmerDirection = 0; 
      
      //UPDATES DISTANCE
      character[r][c].setTempMarchDist(dist-1);
      //RESETTING DITANCE AND DIRECTION IF AT MAXIMUM
      if (dist == 0)
      {
         dist = 5;
         dir++;
         character[r][c].setMarchDir(dir);
         character[r][c].setTempMarchDist(dist);
      }
      
      if (dir == 4)
      {
         character[r][c].setMarchDir(0);
         character[r][c].setTempMarchDist(dist+1);
      }
         
      
      moveVertical = 0;
      moveHorizontal =0;
      if (dir == 0)//DOWN
         moveVertical = -1; 
      if (dir == 2)//UP
         moveVertical = 1;
      if (dir == 1)//RIGHT
         moveHorizontal = -1;
      if (dir == 3)//LEFT
         moveHorizontal = 1;
         
      //SET DIRECTION FARMER FACES
      if (moveVertical < 0)
         farmerDirection = 0;
      else if (moveVertical > 0)
         farmerDirection = 1;
      else if (moveHorizontal > 0)
         farmerDirection = 3;
      else if (moveHorizontal < 0)
         farmerDirection = 2;
   
      //IF SPACE FARMER WANTS TO WALK ON IS WALKABLE, AND EMPTY   
      doMove(r, c, moveVertical, moveHorizontal, farmerDirection);    
   }
   
   public static void doMove(int r, int c, int moveVertical, int moveHorizontal, int farmerDirection)
   {
      if (!map[r - moveVertical][c - moveHorizontal].substring(0,1).equals("2"))
      {  
         if (!map[r - moveVertical][c - moveHorizontal].equals("25"))
         {
            if (map[r - moveVertical][c - moveHorizontal].substring(0, 1).equals("1") 
               && character[r - moveVertical][c - moveHorizontal] == null) 
            {
               //MOVES FARMER OBJECT
               int R = character[r][c].getRow();
               int C = character[r][c].getCol();
               character[R][C].setLocation(R - moveVertical, C - moveHorizontal);
               character[R - moveVertical][C - moveHorizontal] = character[R][C];
               character[R][C] = null;
            }
            //SET DIRECTION FARMER FACES
            character[r - moveVertical][c - moveHorizontal].setDirection(farmerDirection); 
         } 
      }
   }
}