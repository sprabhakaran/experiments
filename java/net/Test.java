import java.net.*;
import java.math.*;
import java.nio.*;
public class Test
{
  public static void main(String arg[]) throws Exception
  {
    InetAddress ip = InetAddress.getByName("192.168.5.100");
    BigInteger b = new BigInteger(ip.getAddress());
    System.out.println(b.longValue());
    
    /*InetAddress ip1 = InetAddress.getByName("192.168.5.110");
    System.out.println(new BigInteger(ip1.getAddress()).longValue());


    long l = 12345678;
    byte[] bytes = ByteBuffer.allocate(8).putLong(l).array();
    String s = new String(bytes);
    System.out.println(s);*/
  }
}
