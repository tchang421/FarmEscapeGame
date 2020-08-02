import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import java.io.*;
	
public class Farm_Driver {
  
   public static JFrame frame;
   public static MyFarmPanel game;	
   public static JPanel menuPanel, playerPanel, gamePanel;
   
   
   public static void main(String[] args) {

      // Creating new Frame
      frame = new JFrame("Farm Animal Escape");
   
        //Create the "cards".
      menuPanel = new Menu();
      gamePanel = new MyFarmPanel();
      playerPanel = new PlayerMenu();
      
      // formating the frame
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setContentPane(menuPanel);
      frame.setSize(1115, 800);
      frame.setLocation(100, 50);
      frame.setVisible(true);     
      frame.setResizable(false);
      
   } 
}
    
     
