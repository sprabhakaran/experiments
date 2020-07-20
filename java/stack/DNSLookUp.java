import java.net.InetAddress;
import java.net.UnknownHostException;
public class DNSLookUp 
{
   public static void main(String[] args)   
   {
      InetAddress hostAddress;
      try
      {
         hostAddress = InetAddress.getByName(args[0]);
         System.out.println (hostAddress.getHostAddress());
      }
      catch (UnknownHostException uhe)  
      {
         System.err.println("Unknown host: " + args[0]);
      }
   }
}

