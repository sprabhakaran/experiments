import java.net.*;
public class ViewSource
{
  public static void main(String arg[]) throws Exception
  {
    URL u = new URL("http://prabha-1145/test/test.php");
    URLConnection uc = u.openConnection();
    uc.connect();
    System.out.println(uc.getLastModified());
  }
}
