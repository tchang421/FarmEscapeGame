public class Food {
   public static void main(String[]args) {
      String name = "carrot";
      int sat = getSatisfaction(name);
      System.out.println(sat);
   }

   public static int getSatisfaction (String name)
   {
      name = name.toLowerCase();
      switch (name){
         case("carrot"): 
            return 2;
         case("corn"): 
            return 3;
         case("potato"): 
            return 4;
      
         default: 
            return 0; 
      }
   }
}