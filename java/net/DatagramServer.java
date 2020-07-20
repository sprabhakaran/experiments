import java.net.*;
import java.io.*;
public class DatagramServer
{
  public static DatagramSocket ds;
  public static byte buffer[] = new byte[1024];
  public static int clientport = 1999, serverport=2000;
  public static void main(String arg[]) throws Exception
  {
    ds = new DatagramSocket(serverport);
    BufferedReader dis = new BufferedReader(new InputStreamReader(System.in));
    System.out.println("Server waiting for input");
    InetAddress ia = InetAddress.getByName("localhost");
    while(true)
    {
      String str = dis.readLine();
      if(str == null || str.equals("end"))
      {
        break;
      }
      ds.send(new DatagramPacket(buffer, str.length(), ia, clientport));
    }
  }
}
