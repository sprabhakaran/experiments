import java.lang.reflect.Field;

public class FieldTrouble {
  public Integer val = 10;

  public static void main(String... args) {
    FieldTrouble ft = new FieldTrouble();
    try {
      Class<?> c = ft.getClass();
      Field f = c.getDeclaredField("val");
      //f.setInt(ft, 42);               // IllegalArgumentException
      System.out.println(f);

      // production code should handle these exceptions more gracefully
    } catch (NoSuchFieldException x) {
      x.printStackTrace();
    } 
  }
}
