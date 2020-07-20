import java.io.*;
public class RuntimeTest
{
   public static void main(String args[]) throws Exception
   {
      Runtime rt = Runtime.getRuntime();
      Process p = rt.exec("ls");
      BufferedReader bfIn = new BufferedReader(new InputStreamReader(p.getInputStream()));
      String strLine;
      while ((strLine = bfIn.readLine()) != null)
      {
         System.out.println(strLine);
      }
      bfIn.close();

   }
} 
