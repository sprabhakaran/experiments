public class ObjectCreation extends Thread
{
  public void run()
  {
    for( int i=0; i<100; i++)
    {
      TestObj.getInstance();
    }
  }
  public static void main( String arg[] )
  {
    ObjectCreation ob1 = new ObjectCreation();
    ob1.start();
    ObjectCreation ob2 = new ObjectCreation();
    ob2.start();
    for(int i=0; i<10; i++)
    {
      new ObjectCreation().start();
    }
  }
}

class TestObj
{
  public static TestObj inst = null;
  public TestObj()
  {
    System.out.println(" Object created ");
  }

  public static TestObj getInstance()
  {
    //synchronized(TestObj.class)
    //{
      if( inst == null)
      {
        inst = new TestObj();
      }
    //}
    return inst;
  }
}
