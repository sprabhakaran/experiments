
public class Test {

  public static void main (String arg[]){
    System.out.println(add(1 , 2, 3, 4, 5));
    System.out.println(add(new int[]{1, 2, 3, 4, 5}));
  }

  static int add(int... num) {
    int s = 0;
    for (int i=0; i<num.length; i++){
      s += num[i];
    }
    return s;
  }

}