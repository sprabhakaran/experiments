import java.io.*;
import java.util.*;
public class WordCount
{
   public static void main(String arg[]) throws Exception
   {
      File file = new File(arg[0]);
      Scanner sc = new Scanner(new FileInputStream(file));
      int count=0;
      while(sc.hasNext()){
             sc.next();
                 count++;
      }
      System.out.println("Number of words: " + count);

   }
}
