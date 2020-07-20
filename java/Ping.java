import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Ping 
{
   public static void main(String[] args) 
   {
      BufferedReader bfIn = null;
      String strHost = "prabhakaran";
      if ( args.length > 0 )
      {
         strHost = args[0];
      }
      try 
      {
         Runtime objRuntime = Runtime.getRuntime();
         Process objProcess = objRuntime.exec("ping " + strHost);
         if (objProcess == null) 
         {
            System.out.println("Could not connect");
         }
         bfIn = new BufferedReader(new InputStreamReader(objProcess.getInputStream()));
         String strLine;
         while ((strLine = bfIn.readLine()) != null) 
         {
            System.out.println(strLine);
         }
         bfIn.close();
      }
      catch (IOException e)
      {
         System.err.println(e.toString());
      }
   }
}
