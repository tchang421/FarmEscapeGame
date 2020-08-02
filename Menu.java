import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;
import java.awt.CardLayout;

public class Menu extends JPanel   
{

   private ImageIcon pic, title;
   protected static boolean menuOpen;
   private boolean menuopen;
   private int BUTTON_LOCATION_X = 421;
   private int BUTTON_LOCATION_Y = 612;
   private int BUTTON_SIZE_Y = 157;
   private int BUTTON_SIZE_X = 157;
   private int BUTTON1_LOCATION_X = 150;
   private int BUTTON1_LOCATION_Y = 612;
   private int BUTTON1_SIZE_Y = 157;
   private int BUTTON1_SIZE_X = 157;
   
   public boolean menuopen()
   {
      return menuOpen;
   }
   
   public Menu() 
   {
      this.setLayout(null);
      pic = new ImageIcon("PImages/StartScreen.PNG");
      menuOpen = true;
      
      //Creating Button, Painting image on button, adding button to panel, adding actionlistener to button
      JButton Start = new JButton(); 
      Start.setBounds(BUTTON_LOCATION_X, BUTTON_LOCATION_Y, BUTTON_SIZE_X, BUTTON_SIZE_Y );
      Start.setIcon(new ImageIcon("PImages/button.png"));
      add(Start);
      Start.addActionListener(new Listen2());
      
      //Creating Button, Painting image on button, adding button to panel, adding actionlistener to button
      JButton End = new JButton(); 
      End.setBounds(BUTTON1_LOCATION_X, BUTTON1_LOCATION_Y, BUTTON1_SIZE_X, BUTTON1_SIZE_Y );
      End.setIcon(new ImageIcon("PImages/exitbutton.png"));
      add(End);
      End.addActionListener(new Listen1());
      
      
      
      repaint();
   }
  
   // Paints the background onto the panel
   public void paintComponent(Graphics g)
   {   
      g.drawImage(pic.getImage(), 0, 0, null);
   
   }
   
   // Action Listener for "Exit" button, exits the program
   private class Listen1 implements ActionListener
   {
      public void actionPerformed(ActionEvent e)
      {
         System.exit(0);
      }
   
   }
   
   // Action Listener for "New Game" button, switches panels to Player Menu
     private class Listen2 implements ActionListener
   {
      public void actionPerformed(ActionEvent e)
      {
         Farm_Driver.frame.setContentPane(Farm_Driver.playerPanel);
         Farm_Driver.frame.revalidate();
         Farm_Driver.playerPanel.requestFocus();
         
         
         
      }
   
   }
  
   
   

}