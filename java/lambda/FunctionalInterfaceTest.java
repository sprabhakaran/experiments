import java.io.File;

public class FunctionalInterfaceTest {
  public static void main (final String args[]) {
    final Drawable d = (final int x, final int y) -> {
      System.out.println("Draw function called x : " + x + "   y :: " + y);
    };

    d.draw(10, 20);

    Addable a = (x, y, s) -> {
      return (x + y + Integer.parseInt(s)); 
    };

    int 
      r = a.add(10, 20, "30");
    System.out.println("resutl : " + r);
    File f = new File("./aa");
    if(!f.exists()){
      System.out.println("Yes file exists");
    }
  }
}

interface Drawable {
  public void draw(int x, int y);
  // public void draw1(); //Wont works for functional interface
}

interface Addable {
  public int add( int x, int y, String s);
}
