public class LogicalOperatorsDemo {

  public LogicalOperatorsDemo() {
    boolean x = true;
    boolean y = false;
    System.out.println("x & y : " + (x & y));
    System.out.println("x && y : " + (x && y));
    System.out.println("x | y : " + (x | y));
    System.out.println("x || y: " + (x || y));
    System.out.println("x ^ y : " + (x ^ y));
    System.out.println("!x : " + (!x));
  }
  public static void main(String args[]) {
    testrest();
  }
  public static void testrest()
  {
    System.out.println(0 & 0);
  }
}

