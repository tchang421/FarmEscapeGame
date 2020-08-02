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
   
public class MyFarmPanel extends JPanel implements KeyListener
{
   //ITEM IMAGES  
   private ImageIcon carrotitem = new ImageIcon("images/food/carrotitem.gif");
   private ImageIcon cornitem = new ImageIcon("images/food/cornitem.gif");
   private ImageIcon poopitem = new ImageIcon("images/traps/poopitem.gif");
   
   //SECOND TERRAIN
   private ImageIcon tree1 = new ImageIcon("images/tree1.gif");
   
   //DOUBLE ARRAY, MAPS
   protected static int fovWidth = 25, fovHeight = 25;
   
   //ZOOM
   private boolean zoomed = false;
   
   ///////PROTECTED: allows subclass to access parent class variables
   /////////////////////////////////////////////////////////////////////////////////////////////
   protected static String[][] map;
   protected static Player[][] character;
   protected static int[][] item;
   
   protected static int SIZE=32;
   
   //PLAYER VARIABLES
   protected static int playerR;
   protected static int playerC;
   protected static int playerDirection = 2;

   //MOVING MECHANICS
   protected static long lastPressTime = 0;   
   protected static boolean canMove = true;
   
   //CAPTURING
   protected static boolean captured = false; 
   protected static boolean justReleased = false; 
   protected static int capturedStatus = 5; 
   protected static  int  minDist = 100000000;
   protected  static int  closeR = 0;
   protected  static int  closeC = 0;
   
   //CHARACTERS
   protected static Player capturedPlayer;
   protected static Player Me;
   protected static Player farmerJoe;
   protected static Player farmerBob;
   protected static Player cow1;
   
   //PANEL STUFF
   protected static JLabel journal;
   protected static JLabel background;
   protected static ImageIcon backGround;
   
   //STAT PANEL
   protected boolean stat = true;
   protected static boolean paintStatPanel = false;
   protected static long lastStatTime = 0;
   protected static int statTimer = 500;
   
   //EARTHQUAKE 
   protected long time;
   
   
/////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////  
/////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////   

   public MyFarmPanel()
   {  
     // this.setLayout(null);
   
      //DOUBLE ARRAY, MAPS
      map = new String[201][201];  
      character = new Player [201][201];
      item = new int [201][201];
      
      //FOOD INTIALIZED   
      item[105][105] = 1;
      item[95][95] = 2;
      item[110][110] = 3;
      
      addKeyListener(this);
      
      //PLAYER LOCATION
      playerR = map.length / 2;     	
      playerC = map[0].length / 2; 
      
      //CHARACTER INITIALIZER
      Me = new Player(map.length/2, map[0].length/2, 0);
      character[map.length/2][map[0].length/2] = Me;
      character[playerR][playerC].setSpeed(1000);
      
      //FARMER INITIALIZER
      farmerJoe = new Player(map.length/2 - 4, map[0].length/2 + 4, 1);
      character[map.length/2 - 4][map[0].length/2 + 4] = farmerJoe;
      
      farmerBob = new Player(map.length/2 + -20, map[0].length/2 - 20, 1);
      character[map.length/2 - 20][map[0].length/2 - 20] = farmerBob;
      character[farmerBob.getRow()][farmerBob.getCol()].setTypeOfMovement(2);
      //character[farmerBob.getRow()][farmerBob.getCol()].setTypeOfMovement(1);
      
      //ANIMAL INITIALIZER
      cow1 = new Player(playerR + 2, playerC + 2, 2);
      character[playerR + 2][playerC + 2] = cow1; 
      
      //MAP INTIALIZER     
      Scanner input = null;
      try 
      {
         input = new Scanner(new File("sampleMap.txt"));
      } 
      catch (FileNotFoundException e)
      {
         System.out.println("OH NO!");
      }
      map = mapInitializer.initializeMap(map);
       
   }   
   
   
    
   public void showBoard(Graphics g)	
   {
      if (!zoomed)
      {
         //FARMER GRABS CHICKEN/FARMER LETS GO
         minDist = 1000000;
         closeR = 0;
         closeC = 0;
         Interaction.capturingPlayer();
      
         //DRAWS FIELD OF VISION (TERRAIN)
         for(int r=0;r<fovHeight;r++)
         {
            for(int c=0;c<fovWidth;c++)
            {
               //mapR AND mapC ARE THE INDECIES IN RELATION TO THE WHOLE MAP
               int mapR = r + playerR - fovHeight / 2;
               int mapC = c + playerC - fovWidth / 2;
               String mapKey = map[mapR][mapC];
            
               //DRAWING TERRAIN 
               int terrainIndex = Integer.parseInt(mapKey.substring(1));
               g.drawImage(Images.terrain[terrainIndex].getImage(), c * SIZE, r * SIZE, SIZE, SIZE, null); 
            }
         }
         
         //DRAWS FIELD OF VISION (CHARACTERS, ITEMS)
         for(int r=0;r<fovHeight;r++)
         {
            for(int c=0;c<fovWidth;c++)
            {
               //mapR AND mapC ARE THE INDECIES IN RELATION TO THE WHOLE MAP
               int mapR = r + playerR - fovHeight / 2;
               int mapC = c + playerC - fovWidth / 2;
               String mapKey = map[mapR][mapC];
               
               //DRAWING SECOND TERRAIN
               if(mapR == 60 && mapC == 140)
               {
                  g.drawImage(Images.secondTerrain[0].getImage(), c * SIZE-15, r * SIZE-16, SIZE*2, SIZE*2, null);
               }
                
               //DRAWING CHARACTERS
               if(character[mapR][mapC] != null) 
               {	
                  int typeOfPlayer = character[mapR][mapC].getPlayerType();
                  int directionOfPlayer = character[mapR][mapC].getDirection();
                  if (character[mapR][mapC].hasCaptive()) /// if the player has a captive animal
                     directionOfPlayer = 4;
                  if (typeOfPlayer == 2)
                     g.drawImage(Images.characterImages[typeOfPlayer][directionOfPlayer].getImage(), c * SIZE-15, r * SIZE-16, SIZE*2, SIZE*2, null);
                  else 
                     g.drawImage(Images.characterImages[typeOfPlayer][directionOfPlayer].getImage(), c * SIZE, r * SIZE, SIZE, SIZE, null);
               
               }
            
               //FARMER GOES CRAZY
               /*  if (item[farmerR][farmerC] != 0)
               {
                  food[farmerR][farmerC] = 0;
                  farmerspeed = farmerspeed + 2000;              
               }*/
            
               //DRAWING FOOD
               if (item[mapR][mapC] != 0)
               {
                  boolean canEat = false;
                  if (character[mapR][mapC] != null)
                  {
                     canEat = true;
                     doItemEffect(item[mapR][mapC], mapR, mapC);
                  }
                  else
                  {
                     int itemImageIndex = item[mapR][mapC] - 1;
                     g.drawImage(Images.item[itemImageIndex].getImage(), c * SIZE, r * SIZE, SIZE, SIZE, null);
                  }
               }
            }
         }  
      }//END OF ZOMED IF STATEMENT
      
      //ZOOMED OUT IMAGE
      if (zoomed)
      {
         for(int r=0;r<194;r++)
         {
            for(int c=0;c<201;c++)
            {
               String mapKey = map[r+4][c];
               int terrainIndex = Integer.parseInt(mapKey.substring(1));
               g.drawImage(Images.terrain[terrainIndex].getImage(), c * SIZE, r * SIZE, SIZE, SIZE, null);
            }
         }    
         g.drawImage(Images.characterImages[0][0].getImage(), playerC * SIZE - 9, (playerR-4) * SIZE -9, SIZE*5, SIZE*5, null);
      }
      
      //IN STAT AREA
     // for(int r=0; r<fovHeight+5 ;r++) 
      //{
        // for(int c=fovWidth; c<fovWidth+5 ;c++)
         //{
          //  g.drawImage(Images.terrain[3].getImage(), c * 32, r * 32, 32, 32, null);
       //  }
     // } 
   }
   
   
   public void doItemEffect(int name, int r, int c)
   {
      if (name == 1) //CARROT
      {
       //  if (character[r][c].getPlayerType() == 0)
         {
            character[r][c].setSpeed(character[r][c].getSpeed()+3000);
            item[r][c] = 0;
         }
      }
      if (name == 2) //CORN
      {
      //   if (character[r][c].getPlayerType() == 0)
         {
            character[r][c].setSpeed(character[r][c].getSpeed()-1000);
            item[r][c] = 0;
         }
      }
      if (name == 3) //POOP
      {
         character[r][c].setTimeIndex(character[r][c].getTimeIndex()+2000);
         item[r][c] = 0;
      }  
   }
   
   
   public void processUserInput(int k)
   {   
      //MOVEMENT DIRECTION  
      int moveVertical = 0;
      int moveHorizontal = 0;
      
      //CHECKS FOR SPEED OF MOVEMENT//PREVENT SPAMMING
      if(character[playerR][playerC].getTimeIndex() + 1000-character[playerR][playerC].getSpeed() > System.currentTimeMillis())
         canMove = false;
      else
      {
         character[playerR][playerC].setTimeIndex(System.currentTimeMillis());
         canMove = true;
      }
       
      //END PROGRAM  
      if(k==KeyEvent.VK_Q || k==KeyEvent.VK_ESCAPE)				
      {
         System.exit(1);
      }
      
      //ZOOM
      if (k==KeyEvent.VK_M)		
      {
         if (zoomed)//ZOOMED OUT TO MAP
         {
            zoomed = false;
            SIZE = 32;
         }
         else //ZOOMED IN TO REG VIEW  
         {
            zoomed = true;
            SIZE = 4;
         }
      }
        
      //ATTACKING FARMER WHEN CAPTURED   
      if(k==KeyEvent.VK_A && character[playerR][playerC].isCaptured() && !zoomed)
      {
         capturedStatus--;
      }
         
      //IF CAPTURED -> PLAYER CANT MOVE
      if (captured)
         canMove = false;
   
      //PLAYER MOVEMENT   
      if (canMove && !zoomed)
      {
         //IF FARMER JUST RELEASED PLAYER, ENABLE HIM TO CAPTURE AGAIN
         if (justReleased)
         {
            justReleased = false;
         }
         
         //SETS MOVEMENT DIRECTION
         if(k==KeyEvent.VK_UP)        //UP: moveVertical = 1
            moveVertical = 1;
         else if(k==KeyEvent.VK_DOWN) //DOWN: moveVertical = -1
            moveVertical = -1;
         else if(k==KeyEvent.VK_LEFT) //LEFT: moveHorizontal = 1
            moveHorizontal = 1;
         else if(k==KeyEvent.VK_RIGHT)//RIGHT: moveHorizontal = -1
            moveHorizontal = -1;  
            
         //TEMP FR TEST MOVING
         /////////////////////////////////////
         /////////////////////////////////////
         if(k==KeyEvent.VK_W)        //UP: moveVertical = 1
            moveVertical = 5;
         else if(k==KeyEvent.VK_S) //DOWN: moveVertical = -1
            moveVertical = -5;
         else if(k==KeyEvent.VK_A) //LEFT: moveHorizontal = 1
            moveHorizontal = 5;
         else if(k==KeyEvent.VK_D)//RIGHT: moveHorizontal = -1
            moveHorizontal = -5;  
         /////////////////////////////////////
         /////////////////////////////////////
            
         //CHECKS IF PLAYERS MOVEMENT IS WITHIN MAP BOUNDARIES   
         if (playerR - moveVertical>fovHeight/2 && playerR + fovHeight/2 +- moveVertical < map.length &&
                playerC - moveHorizontal>fovWidth / 2 && playerC + fovWidth/2 - moveHorizontal < map[0].length)
         {
            //CHECKS IF PLAYER IS MOVING TO AN EMPTY, WALKABLE TILE
            if (map[playerR - moveVertical][playerC - moveHorizontal].substring(0, 1).equals("1") 
                && character[playerR - moveVertical][playerC - moveHorizontal] == null)
            {
               //CHANGES PLAYER POSITION//MOVES THE PLAYER OBJECT
               playerR = playerR - moveVertical;
               playerC = playerC - moveHorizontal;
               character[playerR][playerC] = character[playerR + moveVertical][playerC + moveHorizontal];
               character[playerR][playerC].setLocation(playerR, playerC);
               character[playerR + moveVertical][playerC + moveHorizontal] = null;
            }
            
            //TEMP FR TEST MOVING
         /////////////////////////////////////
         /////////////////////////////////////
            if(k==KeyEvent.VK_W)        //UP: moveVertical = 1
               moveVertical = 1;
            else if(k==KeyEvent.VK_S) //DOWN: moveVertical = -1
               moveVertical = -1;
            else if(k==KeyEvent.VK_A) //LEFT: moveHorizontal = 1
               moveHorizontal = 1;
            else if(k==KeyEvent.VK_D)//RIGHT: moveHorizontal = -1
               moveHorizontal = -1;  
         /////////////////////////////////////
         /////////////////////////////////////
            
            //CHANGES DIRECTION THAT THE PLAYER IS FACING
            if (moveVertical == -1)
               character[playerR][playerC].setDirection(0);
            else if (moveVertical == 1)
               character[playerR][playerC].setDirection(1);
            else if(moveHorizontal == -1)
               character[playerR][playerC].setDirection(2);
            else if(moveHorizontal == 1)
               character[playerR][playerC].setDirection(3);     
         }
      }
      
      //HARVEST
      /*
      if (map[playerR][playerC].equals("10"))
         map[playerR][playerC] = "13";
      else
         map[playerR][playerC] = "10";
         */
      
   }
   
   ////////////////////////
   /////////////////////////EARTHQUAKE
   public void earthquake()
   {
      boolean canShake = true;
      //CHECKS FOR SPEED OF MOVEMENT//PREVENT SPAMMING
      if(time + 30 > System.currentTimeMillis())
         canShake = false;
      else
      {
         time = System.currentTimeMillis();
         canShake = true;
      }
      
      if (canShake)
      {
         int tempSize = (int)(Math.random() * 6 + 29);
         SIZE = tempSize;
      }
   
   }
   /////////////////////////
   
   public void paintComponent(Graphics g)
   {
      super.paintComponent(g);
      if (!zoomed)
         Movement.farmerMove();
      showBoard(g);
      
      /////////////
     //if (!zoomed)
       //  earthquake();
      /////////////
      repaint();
   }
   
   public void statPanel(Graphics g) {
   /*
      g.setColor(Color.red);
      g.fillRect(800, 0, 328, 840);
      
      
      java.awt.Graphics2D g2 = (java.awt.Graphics2D) g.create();
      g2.setStroke(new java.awt.BasicStroke(3)); // thickness of 3.0f
      g2.setColor(Color.BLACK);
      g2.drawRect(800,1 ,307, 768); 
    */  
    /*
      backGround = new ImageIcon("statbackground.PNG");
      background = new JLabel();
      background.setIcon(backGround);
      background.setBounds(800, 0, 320 , 810); // (X_VALUE, Y_VALUE, X_LENGTH, Y_HEIGHT) 
      this.add(background);
      
      journal = new JLabel("Journal");
      journal.setBounds(900, 35, 100, 80); // (X_VALUE, Y_VALUE, X_LENGTH, Y_HEIGHT)
      journal.setFont(new Font("Arial", Font.PLAIN, 30)); 
      this.add(journal);    
      */  
   }
  
   public void keyTyped(KeyEvent e)
   {
         
   }
         
   public void keyPressed(KeyEvent e)
   {
      processUserInput(e.getKeyCode());
   }
    
   public void keyReleased(KeyEvent e)
   {
      
   }
}