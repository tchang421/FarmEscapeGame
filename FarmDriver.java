import javax.swing.JFrame;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import java.util.*;
import java.io.*;
   
public class FarmDriver
{
   public static MyFarmPanel screen;	
   
   public static void main(String[]args)
   {
     screen = new MyFarmPanel();
     JFrame frame = new JFrame("Farm");
     frame.setSize(775, 795);
     frame.setLocation(100, 50);
     frame.setContentPane(new MyFarmPanel());
     frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
     frame.setVisible(true);
     frame.addKeyListener(new listen());
   }
   
   public static class listen implements KeyListener 
      {
      
         public void keyTyped(KeyEvent e)
         {
         
         }
         
         public void keyPressed(KeyEvent e)
         {
         
         }
      
         public void keyReleased(KeyEvent e)
         {
            screen.processUserInput(e.getKeyCode());
         }
      }
   
   
}