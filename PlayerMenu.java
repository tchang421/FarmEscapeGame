import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;

public class PlayerMenu extends JPanel 
{
   private ImageIcon pic, title;
   protected static boolean menuOpen;
   private boolean menuopen;
   private int BACK_LOCATION_X = 20;
   private int BACK_LOCATION_Y = 22;
   private int BACK_SIZE_Y = 63;
   private int BACK_SIZE_X = 227;
   
   private int COW_LOCATION_X = 340;
   private int COW_LOCATION_Y = 591;
   private int COW_SIZE_Y = 144;
   private int COW_SIZE_X = 130;
   
   private int PIG_LOCATION_X = 497;
   private int PIG_LOCATION_Y = 373;
   private int PIG_SIZE_Y = 93;
   private int PIG_SIZE_X = 74;
   
   private int CHICKEN_LOCATION_X = 252;
   private int CHICKEN_LOCATION_Y = 372;
   private int CHICKEN_SIZE_Y = 93;
   private int CHICKEN_SIZE_X = 72;
   
   public boolean menuopen()
   {
      return menuOpen;
   }
   
   public PlayerMenu() 
   {  
   
      this.setLayout(null);
      pic = new ImageIcon("PImages/PlayerScreen.PNG");
      menuOpen = true;
JButton Back = new JButton(); 
      Back.setBounds(BACK_LOCATION_X, BACK_LOCATION_Y, BACK_SIZE_X, BACK_SIZE_Y );
      Back.setIcon(new ImageIcon("PImages/BACKBUTTON.png"));
      add(Back);
      Back.addActionListener(new Listen1());
     
      JButton Chicken = new JButton(); 
      Chicken.setBounds(CHICKEN_LOCATION_X, CHICKEN_LOCATION_Y, CHICKEN_SIZE_X, CHICKEN_SIZE_Y );
      Chicken.setIcon(new ImageIcon("PImages/chickenbutton.png"));
      add(Chicken);
      Chicken.addActionListener(new Listen2());
     
      JButton Cow = new JButton(); 
      Cow.setBounds(COW_LOCATION_X, COW_LOCATION_Y, COW_SIZE_X, COW_SIZE_Y );
      Cow.setIcon(new ImageIcon("PImages/cowbutton.png"));
      add(Cow);
      //Cow.addActionListener(new Listen1());
      
      JButton Pig = new JButton(); 
      Pig.setBounds(PIG_LOCATION_X, PIG_LOCATION_Y, PIG_SIZE_X, PIG_SIZE_Y );
      Pig.setIcon(new ImageIcon("PImages/pigbutton.png"));
      add(Pig);
      //Pig.addActionListener(new Listen1());
      repaint();
   }
  

   public void paintComponent(Graphics g)
   {   
       g.drawImage(pic.getImage(), 0, 0, null); 
   }
  
   private class Listen1 implements ActionListener
   {
      public void actionPerformed(ActionEvent e)
      {
      Farm_Driver.frame.setContentPane(Farm_Driver.menuPanel);
         Farm_Driver.frame.revalidate();
         Farm_Driver.menuPanel.requestFocus();
      }
   
   }
   
   private class Listen2 implements ActionListener
   {
      public void actionPerformed(ActionEvent e)
      {
         
       Farm_Driver.frame.setContentPane(Farm_Driver.gamePanel);
         Farm_Driver.frame.revalidate();
         Farm_Driver.gamePanel.requestFocus();

         
      }
   
   }

   public void processUserInput(int k)
   {
      if(k==KeyEvent.VK_S)
      {
         menuOpen = false;
      }
   }
}