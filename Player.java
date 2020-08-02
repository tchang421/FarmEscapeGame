public class Player
{
   private int speed, strength, health, stealth, row, col, playerType, direction, typeOfMovement, save, marchDist, marchDir, tempMarchDist;
   private boolean captive, captured;
   private long timeIndex;
   
   /*
   playerType key: 
   0 = chicken
   1 = farmer
   2 = cow
   */
   public Player(int r, int c, int p)
   {
      speed = 0; 
      strength = 10;
      health = 10;
      stealth = 10;
      row = r;
      col = c;
      playerType = p;
      direction = 1;
      captive = false;
      captured = false;
      timeIndex = 0;
      typeOfMovement = 0;
      save = 0;
      marchDist = 5;
      marchDir = 0;
      tempMarchDist = marchDist;
   }
   
   public Player(int sp, int str, int hp, int ste, int r, int c, int p, int m, int s)
   {
      speed = sp; 
      strength = str;
      health = hp;
      stealth = ste;
      row = r;
      col = c;
      playerType = p;
      direction = 1;
      captive = false;
      captured = false;
      timeIndex = 0;
      typeOfMovement = m;
      save = s;
      marchDist = 5;
      marchDir = 0;
      tempMarchDist = marchDist;
   }
   
   public void setLocation(int r, int c)
   {
      row = r;
      col = c;
   }
   
   public int getRow()
   {
      return row;
   }
   
   public int getCol()
   {
      return col;
   }
   
   public void setDirection(int d)
   {
      direction = d;
   }
   
   public int getDirection()
   {
      return direction;
   }
   
   public int getPlayerType()
   {
      return playerType;
      /////////////////
      // 0: chicken
      // 1: farmer
      /////////////////
   }
   
   public void setPlayerType(int i)
   {
      playerType = i;
   }
   
   public int getSpeed()
   {
      return speed;
   }
 
   public long getTimeIndex()
   {
      return timeIndex;
   }
   
   public void setTimeIndex(long i)
   {
      timeIndex = i;
   }
   
   public int getStrength()
   {
      return strength;
   }
   
   public int getStealth()
   {
      return stealth;
   }
   
   public int getHealth()
   {
      return health;
   }
   
   public void setSpeed(int s)
   {
      speed = s;
   }
   
   public void setStrength(int s)
   {
      strength = s;
   }
   
   public void setStealth(int s)
   {
      stealth = s;
   }
   
   public void sethealth(int h)
   {
      health = h;
   }
   
   public void setHasCaptive(boolean b)
   {
      captive = b;
   }
   
   public boolean hasCaptive()
   {
      return captive;
   }
   
   public void setCaptured(boolean b)
   {
      captured = b;
   }
   
   public boolean isCaptured()
   {
      return captured;
   }
   
   public void setTypeOfMovement(int doggo)
   {
      typeOfMovement = doggo;
      //CHASE
      if (doggo == 1)
      {
         setSave(getSpeed());
         setSpeed(500);
      }
      //NORMAL 
      else if (doggo == 0)
         setSpeed(getSave());
   }
   
   public int getTypeOfMovement()
   {
      return typeOfMovement;
      /////////////////
      // 0: random
      // 1: chase
      // 2: 
      /////////////////
   }
   
   public void setSave(int s)
   {
      save = s;
   }
   
   public int getSave()
   {
      return save;
   }
   
   public int getMarchDir()
   {
      return marchDir;
   }
   
   public void setMarchDir(int t)
   {
      marchDir = t;
   }
   
   public int getMarchDist()
   {
      return marchDist;
   }
   
   public void setMarchDist(int tehe)
   {
      marchDist = tehe;
      tempMarchDist = tehe;
   }
   
   public int getTempMarchDist()
   {
      return tempMarchDist;
   }
   
   public void setTempMarchDist(int t)
   {
      tempMarchDist = t;
   }
   
}