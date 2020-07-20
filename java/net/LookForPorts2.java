import java.net.*;
import java.io.*;


public class LookForPorts2 
{
  public static void main(String[] args) 
  {
    Socket theSocket;
    String host = "localhost";
    if (args.length > 0) {
      host = args[0];
    }
    try 
    {
      InetAddress theAddress = InetAddress.getByName(host);
      System.out.println(theAddress);
      for (int i = 1024; i < 65536; i++) 
      {
        try 
        {
          theSocket = new Socket(theAddress, i);
          System.out.println("There is a server on port " + i + " of " + host);
        }
        catch (IOException e) 
        {
        }
      } 
    }
    catch (UnknownHostException e) {
      System.err.println(e);
    }

  }

}
