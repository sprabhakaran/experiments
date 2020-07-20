import java.net.*;
public class DatagramClient
{
  public static DatagramSocket ds;
  public static byte buffer[] = new byte[1024];
  public static int clientport = 1999, serverport=2000;
  public static void main(String[] arg) throws Exception
  {
    ds = new DatagramSocket(clientport);
    System.out.println("Client is waiting for server to send data");
    while(true)
    {
      DatagramPacket dp = new DatagramPacket(buffer, buffer.length);
      ds.receive(dp);
      String psx = new String(dp.getData(),0,dp.getLength());
      System.out.println(psx);
    }
  }
}
