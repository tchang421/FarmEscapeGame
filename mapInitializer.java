import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class mapInitializer
{
   static Scanner input = null;
   
   public static String[][] initializeMap(String[][] map)
   {
      ////////////////////////////////////
      //FENCES
      ////////////////////////////////////
      for (int r = 19; r < 183; r++)
      {
         for (int c = 19; c < 183; c++)
         {
            if (r == 19 && c > 19 && c < 180)
            map[r][c] = "26";
            if (r == 180 && c > 19 && c < 180)
            map[r][c] = "26";
            if (c == 19 && r > 19 && r < 180)
            map[r][c] = "27";
            if (c ==180 && r > 19 && r < 180)
            map[r][c] = "27";
            
            //CORNERS
            if (r == 19 && c == 19)
            map[r][c] = "212";
            if (r == 19 && c == 180)
            map[r][c] = "211";
            if (r == 180 && c == 180)
            map[r][c] = "28";
            if (r == 180 && c == 19)
            map[r][c] = "210";
         }
      }
      

      ////////////////////////////////////
      //sample map
      ////////////////////////////////////
      /*
      String name = "Map/sampleMap.txt";
      findException(name);

      for (int r = 88; r < 115; r++)
      {
         for (int c = 88; c < 115; c++)
         {
            int val = input.nextByte();
            map[r][c] = "" + val;
         }
      }
      */
      ////////////////////////////////////
      //tile 1
      ////////////////////////////////////
      
      input = null;
      String name = "Map/tile1.txt";
      findException(name);
      
      for (int r = 20; r < 60; r++)
      {
         for (int c = 20; c < 60; c++)
         {
            int val = input.nextInt();
            map[r][c] = "" + val;
         }
      }

      ////////////////////////////////////
      //tile 2
      ///////////////////////////////////
      
      input = null;
      name = "Map/tile2.txt";
      findException(name);
      
      for (int r = 20; r < 60; r++)
      {
         for (int c = 60; c < 100; c++)
         {
            int val = input.nextInt();
            map[r][c] = "" + val;
         }
      }
      
      ////////////////////////////////////
      //tile 3
      ///////////////////////////////////
      
      input = null;
      name = "Map/tile3.txt";
      findException(name);
      
      for (int r = 20; r < 60; r++)
      {
         for (int c = 100; c < 140; c++)
         {
            int val = input.nextInt();
            map[r][c] = "" + val;
         }
      }
      
      ////////////////////////////////////
      //tile 4
      ////////////////////////////////////
      
      input = null;
      name = "Map/tile4.txt";
      findException(name);
      
      for (int r = 20; r < 60; r++)
      {
         for (int c = 140; c < 180; c++)
         {
            int val = input.nextInt();
            map[r][c] = "" + val;
         }
      }
      
       ////////////////////////////////////
      //tile 5
      ////////////////////////////////////
      
      input = null;
      name = "Map/tile5.txt";
      findException(name);
      
      for (int r = 60; r < 100; r++)
      {
         for (int c = 20; c < 60; c++)
         {
            int val = input.nextInt();
            map[r][c] = "" + val;
         }
      }
      
      ////////////////////////////////////
      //tile 6
      ////////////////////////////////////
      
      input = null;
      name = "Map/tile6.txt";
      findException(name);
      
      for (int r = 60; r < 100; r++)
      {
         for (int c = 60; c < 100; c++)
         {
            int val = input.nextInt();
            map[r][c] = "" + val;
         }
      }
      
      ////////////////////////////////////
      //tile 7
      ////////////////////////////////////
      
      input = null;
      name = "Map/tile7.txt";
      findException(name);
      
      for (int r = 60; r < 100; r++)
      {
         for (int c = 100; c < 140; c++)
         {
            int val = input.nextInt();
            map[r][c] = "" + val;
         }
      }
      
      ////////////////////////////////////
      //tile 8
      ////////////////////////////////////
      
      input = null;
      name = "Map/tile8.txt";
      findException(name);
      
      for (int r = 60; r < 100; r++)
      {
         for (int c = 140; c < 180; c++)
         {
            int val = input.nextInt();
            map[r][c] = "" + val;
         }
      }
      
        ////////////////////////////////////
      //tile 9
      ////////////////////////////////////
      
      input = null;
      name = "Map/tile9.txt";
      findException(name);
      
      for (int r = 100; r < 140; r++)
      {
         for (int c = 20; c < 60; c++)
         {
            int val = input.nextInt();
            map[r][c] = "" + val;
         }
      }
      
        ////////////////////////////////////
      //tile 10
      ////////////////////////////////////
      
      input = null;
      name = "Map/tile10.txt";
      findException(name);
      
      for (int r = 100; r < 140; r++)
      {
         for (int c = 60; c < 100; c++)
         {
            int val = input.nextInt();
            map[r][c] = "" + val;
         }
      }
      
        ////////////////////////////////////
      //tile 11
      ////////////////////////////////////
      
      input = null;
      name = "Map/tile11.txt";
      findException(name);
      
      for (int r = 100; r < 140; r++)
      {
         for (int c = 100; c < 140; c++)
         {
            int val = input.nextInt();
            map[r][c] = "" + val;
         }
      }
      
        ////////////////////////////////////
      //tile 12
      ////////////////////////////////////
      
      input = null;
      name = "Map/tile12.txt";
      findException(name);
      
      for (int r = 100; r < 140; r++)
      {
         for (int c = 140; c < 180; c++)
         {
            int val = input.nextInt();
            map[r][c] = "" + val;
         }
      }
      
      ////////////////////////////////////
      //tile 13
      ////////////////////////////////////
      
      input = null;
      name = "Map/tile13.txt";
      findException(name);
      
      for (int r = 140; r < 180; r++)
      {
         for (int c = 20; c < 60; c++)
         {
            int val = input.nextInt();
            map[r][c] = "" + val;
         }
      }
      
      ////////////////////////////////////
      //tile 14
      ////////////////////////////////////
      
      input = null;
      name = "Map/tile14.txt";
      findException(name);
      
      for (int r = 140; r < 180; r++)
      {
         for (int c = 60; c < 100; c++)
         {
            int val = input.nextInt();
            map[r][c] = "" + val;
         }
      }
      
      ////////////////////////////////////
      //tile 15
      ////////////////////////////////////
      
      input = null;
      name = "Map/tile15.txt";
      findException(name);
      
      for (int r = 140; r < 180; r++)
      {
         for (int c = 100; c < 140; c++)
         {
            int val = input.nextInt();
            map[r][c] = "" + val;
         }
      }

      ////////////////////////////////////
      //tile 16
      ////////////////////////////////////
      
      input = null;
      name = "Map/tile16.txt";
      findException(name);
      
      for (int r = 140; r < 180; r++)
      {
         for (int c = 140; c < 180; c++)
         {
            int val = input.nextInt();
            map[r][c] = "" + val;
         }
      }   
      
      ////////////////////////////////////
      //FILL REST OF SPACE WITH FOREST
      ////////////////////////////////////

      for(int r = 0; r < map.length; r++)	
      {
         for(int c = 0; c < map[0].length; c++) 
         {
            if (map[r][c] == null && r < 13 || c < 13 || r > 187 || c > 187)
            {
               map[r][c] = "25";
            } 
            else if (map[r][c] == null)
            map[r][c] = "15";
         }
      }
     
      return map;
   }
   
   /////////////////////////////////////////////
   /////////////////////////////////////////////
   //EXCEPTION FINDER
   /////////////////////////////////////////////
   public static void findException(String n)
   {
      try 
      {
         String name = n;
         input = new Scanner(new File(name));
      }
      catch (FileNotFoundException e)
      {
         System.out.println("OH NO!");
      }
   }
}