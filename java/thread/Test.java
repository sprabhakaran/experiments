import java.util.*;
import java.util.concurrent.*;
public class Test extends Thread
{
  public static Map map = new ConcurrentHashMap();
  public void run()
  {
    for(int i=0; i<100; i++)
    {
      map.put("key"+i, "val"+i);
    }
  }
  public static void main ( String arg[])
  {
    Thread t = new Test();
    t.start();
    System.out.println(map);
  }
}
