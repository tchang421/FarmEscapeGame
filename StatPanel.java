import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class StatPanel extends JPanel   
{
   protected static boolean paintStatPanel = false;
   protected static JLabel background;
   protected static ImageIcon backGround;
   protected static JLabel journal;
   
   public StatPanel() 
   {
     // this.setLayout(null);
      
      backGround = new ImageIcon("statbackground.PNG");
      background = new JLabel();
      background.setIcon(backGround);
      background.setBounds(800, 0, 320 , 810); // (X_VALUE, Y_VALUE, X_LENGTH, Y_HEIGHT) 
      this.add(background);
      
      
      journal = new JLabel("Journal");
      journal.setBounds(400, 100, 100, 80); // (X_VALUE, Y_VALUE, X_LENGTH, Y_HEIGHT)
      journal.setFont(new Font("Arial", Font.PLAIN, 30)); 
      this.add(journal);  
      
      repaint();
   }
  
   // Paints the background onto the panel
   public void paintComponent(Graphics g)
   {   
      
   
   }
   
   // Action Listener for "Exit" button, exits the program
   private class Listen1 implements ActionListener
   {
      public void actionPerformed(ActionEvent e)
      {
         System.exit(0);
      }
   
   }
  
   
   

}