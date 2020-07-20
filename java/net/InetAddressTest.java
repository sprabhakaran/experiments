import java.net.*;
public class InetAddressTest
{
  public static void main(String arg[]) throws Exception
  {
    InetAddress add = InetAddress.getLocalHost();
    System.out.println(add.toString());
  }

}
