public class Puzzle {
   public static void main(String[] args) 
   {
      System.out.println(System.getProperty("user.dir"));
      Object o = null;
      buzz(o);
   }

   private static void buzz(Object... o) {
      if (o != null)
      {
         System.out.println("Not Null!");
      }
   }
}

