import java.io.*;

public class Reversable
{
   public static int start = 1;
   public static int finish = 10;

   public static void main(String[] args)
   {
      for (int i = start; i != (finish + 1 * ((start < finish) ? 1 : -1)); i += 1 * ((start < finish) ? 1 : -1))
      {
         System.out.println("i = " + i);
      }
      finish = (start + finish) - (start = finish);  
      System.out.println("Finish = " + finish);
      System.out.println("Start = " + start);
      for (int i = start; i != (finish + 1 * ((start < finish) ? 1 : -1)); i += 1 * ((start < finish) ? 1 : -1))
      {
         System.out.println("i = " + i);
      }
      finish = 10;
      for (int i = start; i != (finish + 1 * ((start < finish) ? 1 : -1)); i += 1 * ((start < finish) ? 1 : -1))
      {
         System.out.println("i = " + i);
      }
   }
}

