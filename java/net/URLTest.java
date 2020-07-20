import java.net.*;
public class URLTest
{
  public static void main( String arg[])
    throws Exception
  {
    URL u = new URL("http","localhost",80,"index.html");
    System.out.println(u.getUserInfo());
  }
}
