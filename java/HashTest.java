import java.util.*;
public class HashTest {

  public static void main(String args[]){
    
    HashMap map = new HashMap();
    Object v = map.put("x", 10);
    System.out.println(v);

    Object v1 = map.put("x", 20);
    System.out.println(v1);

    System.out.println(map);
  }

}
