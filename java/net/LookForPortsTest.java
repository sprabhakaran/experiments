import java.net.Socket;
public class LookForPortsTest
{
  public static void main(String arg[]) throws Exception
  {
    for(int i=0; i<100; i++){
      try{
    Socket s = new Socket("localhost",i);
    System.out.println(s.getLocalAddress());
      }catch(Exception e)
      {
      }
    }
  }
}
