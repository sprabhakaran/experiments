import java.util.*;
public class Main
{
  String name = "Main String";
  public void show()
  {
    class Inner
    {
      String name = "Inner String";

      public Inner()
      {
        class InnerIn
        {
          InnerIn()
          {
            System.out.println("Inner In called");
            new Outer();
          }
        }
        new InnerIn();
      }

      public void seeOuter()
      {
        System.out.println(name);
        //System.out.println(Main.this.name);
      }
    }
    Inner in = new Inner();
    in.seeOuter();
    //display(in);
  }

  interface Person
  {
    void showName();
  }

  void dispaly(List al)
  {
    System.out.println(al);
  }

  public static void ggg(Rest.R rr)
  {
    System.out.println("RRRRRRRRRRRRRRRRRR");
  }
  public static void main ( String arg[] )
  {
    Rest.R obj = new Rest.R();
    ggg(obj);
  }
}

class Outer
{
  public Outer()
  {
    System.out.println("Outer class called!!");
  }
}


class Rest
{
  static class R
  {
    R()
    {
      System.out.println("R class intantiated");
    }
  }
}
