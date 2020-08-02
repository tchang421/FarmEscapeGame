import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Container extends JPanel
{
   private static StatPanel stat;
   private static MyFarmPanel farm;
   
public Container()
   {
     // this.setLayout(new BorderLayout());
      
      stat = new StatPanel();
      this.add(stat);
      
      farm = new MyFarmPanel();
      this.add(farm);
   }


}