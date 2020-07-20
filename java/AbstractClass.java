
public class AbstractClass
{
  public static void main ( String arg[])
  {
    B b = new B();
  }
}

abstract class A
{
  {
    System.out.println("Before AAAA");
  }
  public A()
  {
    System.out.println("calling AAAA");
  }
}

class B  extends A
{
  public B()
  {
    System.out.println("calling BBBB");
  }
}
