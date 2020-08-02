import javax.swing.*;
import java.awt.*;

public class Stat_Driver
{
   public static void main(String[] args)
   {
      JFrame frame = new JFrame("Tic Tac Toe!");
      frame.setSize(400, 900);
      frame.setLocation(200, 200);
      frame.setContentPane(new StatPanel());
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setVisible(true);
      frame.setResizable(true);
   
   }
   
  }