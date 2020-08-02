import javax.swing.ImageIcon;

public class Images {
   public static final ImageIcon [] terrain = new ImageIcon[]
   {
      new ImageIcon("images/field.jpg"),
      new ImageIcon("images/sandy.jpg"),
      new ImageIcon("images/grassy.jpg"),
      new ImageIcon("images/corny.jpg"),
      new ImageIcon("images/stillwater.jpg"),
      new ImageIcon("images/forestgump.jpg"),
      new ImageIcon("images/fencehorizontal.jpg"),
      new ImageIcon("images/fencevertical.jpg"),
      new ImageIcon("images/fencedownright.jpg"),
      new ImageIcon("images/stony.jpg"),
      new ImageIcon("images/fencedownleft.jpg"),
      new ImageIcon("images/fenceupright.jpg"),
      new ImageIcon("images/fenceupleft.jpg"),
      new ImageIcon("images/carrotplant.jpg")
   };
   
   public static final ImageIcon [][] characterImages = new ImageIcon[][]
   {
      {
         new ImageIcon("images/chickendown.gif"),
         new ImageIcon("images/chickenup.gif"),
         new ImageIcon("images/chickenright.gif"),
         new ImageIcon("images/chickenleft.gif"),
      },
      {
         new ImageIcon("images/farmerfront.gif"),
         new ImageIcon("images/farmerback.gif"),
         new ImageIcon("images/farmerright.gif"),
         new ImageIcon("images/farmerleft.gif"),
         new ImageIcon("images/farmerwithChicken.gif"),
      },
      {
         new ImageIcon("images/cowDown.gif"),
         new ImageIcon("images/cowUp.gif"),
         new ImageIcon("images/cowRight.gif"),
         new ImageIcon("images/cowLeft.gif"),
      }
   };
   
   public static final ImageIcon [] item = new ImageIcon[] 
   {
      /*
      Key:
      Carrot = 1
      Corn = 2
      Poop = 3
      */
      new ImageIcon("images/food/carrotitem.gif"), 
      new ImageIcon("images/food/cornitem.gif"),
      new ImageIcon("images/traps/poopitem.gif")
   };
   
 //  public static final ImageIcon [] menuTiles = new ImageIcon[]
 //  {
 //     new ImageIcon("images/forestgump.jpg"),
 //  };
   
   public static final ImageIcon [] secondTerrain = new ImageIcon[]
   {  
    /*
    Tree1 = 1
    */
      new ImageIcon ("images/tree1.gif")
   };
}