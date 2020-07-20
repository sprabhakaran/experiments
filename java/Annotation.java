import java.lang.annotation.*;
import java.lang.reflect.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@interface MyAnnotation {
  int value();
}

// Applying annotation
@MyAnnotation(value = 10)
class Hello {
  public void sayHello() {
    System.out.println("hello annotation");
  }
}

// Accessing annotation
public class Annotation {
  public static void main(String args[]) throws Exception {

    Hello h = new Hello();
    Class m = h.getClass();

    // MyAnnotation manno = m.getAnnotation(MyAnnotation.class);
    // MyAnnotation manno = m.getAnnotation(MyAnnotation.class);
    System.out.println("value is: " + manno.value());
  }
}