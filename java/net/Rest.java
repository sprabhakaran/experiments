import java.net.*;
import java.math.*;
import java.nio.*;
public class Rest
{
  public static void main(String arg[]) throws Exception
  {
    InetAddress ip = InetAddress.getByName("192.168.24.184");
   // BigInteger b = new BigInteger(ip.getAddress());
   // System.out.println(b.longValue());
    System.out.println(new BigInteger(ip.getAddress()));
  }
}
