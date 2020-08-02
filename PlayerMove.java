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

public class Interaction extends MyFarmPanel {
   public static void capturingPlayer()
   {
      ////////////////////////////////////////////////////////////////////
      ////////////////////////////////////////////////////////////////////
      //grabbing
   
      for (int r = 0 ; r < character.length; r++)
      {
         for (int c = 0; c < character[0].length; c++)
         {
            if (character[r][c] != null && character[r][c].getPlayerType() == 1
                && Math.abs(r-playerR) + Math.abs(c-playerC) < minDist)
            {
               minDist = Math.abs(r-playerR) + Math.abs(c-playerC);
               closeR = r;
               closeC = c;
            }
         }
      }
         
      if (captured)
      {
         playerR = closeR;
         playerC = closeC;
         Me.setCaptured(true);
      }
         
      if (Math.abs(closeR-playerR) + Math.abs(closeC-playerC) == 1 && !justReleased) //if they are next to each other
      {
         capturedStatus = 5;
         captured = true;
         capturedPlayer = character[playerR][playerC];
         character[playerR][playerC] = null;
         playerR = closeR;
         playerC = closeC;
         character[closeR][closeC].setHasCaptive(true);
      }
      
      ////////////////////////////////////////////////////////////////////
      ////////////////////////////////////////////////////////////////////
      //letting go
      
      if (capturedStatus == 0)
      {
         int farmerDirection = character[closeR][closeC].getDirection();
         int moveVertical = 0;
         int moveHorizontal = 0;
            
         if (farmerDirection == 0)//down
            moveVertical = -1; 
         if (farmerDirection == 1)//up
            moveVertical = 1;
         if (farmerDirection == 2)//right
            moveHorizontal = -1;
         if (farmerDirection == 3)//left
            moveHorizontal = 1;
            
         playerR = closeR + moveVertical;
         playerC = closeC + moveHorizontal;
            
         character[playerR][playerC] = capturedPlayer;
         capturedPlayer = null;
            
         captured = false;
         capturedStatus = 5;
         justReleased = true;
         character[closeR][closeC].setHasCaptive(false);
         Me.setCaptured(false);
      }
   }
}