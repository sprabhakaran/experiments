
public class TestObj
{
  public static void main ( String arg[] )
    throws Exception
  {
    System.out.println("Active count  start :: "+Thread.activeCount() );
    TT obj = new TT();
    obj.start();
    System.out.println("Active count  before :: "+Thread.activeCount() );
    System.out.println(obj.isAlive());
      Thread.sleep(2000);
    System.out.println("Active count After :: "+Thread.activeCount() );
    System.out.println();
  }
}

class TT extends Thread
{
  public TT()
  {
    super("Test thread");
  }

  public void run()
  {
    int i= 0;
    while( true)
    {
      try
      {
        if(i == 5)
        {
          return;
        }
        System.out.println(i);
        sleep(100000);
      }
      catch(java.lang.InterruptedException ex ) 
      {
      }
      i++;
    }
  }
}
