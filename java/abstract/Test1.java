public class Test1 
{
  public static void main ( String arg[] )
  {
    test();
  }

  static void test()
  {
    final String s = "Podango";
    /*class WW implements RR
    {
      public String getString()
      {
        return s;
      }
    }*/

    RR r = new RR()
    {
      public String getString()
      {
        return s;
      }
    };

    System.out.println(r.getString());
  }
}

interface RR
{
}
