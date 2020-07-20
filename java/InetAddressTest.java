import java.net.*;
public class InetAddressTest
{
   public static void main(String args[]) throws Exception
   {
      InetAddress ia = InetAddress.getByName("prabhakaran.zohocorpin.com");
      //InetAddress ia = InetAddress.getByName("192.168.107.10");
      System.out.println(ia.getHostName());
      System.out.println(ia.getHostAddress());
      System.out.println(ia.toString());
   }
} 
