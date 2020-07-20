public class StringTest
{
   public static void main(String[] args)
   {
      foo();
      bar();
   }
   public static void foo()
   {
      String s = "str4";
      String s1 = "str" + s.length();
      System.out.println("(s==s1) = " + (s1==s));
   }
   public static void bar()
   {
      String s = "str4";
      String s1 = "str" + "4";
      System.out.println("(s==s1) = " + (s1==s));
   }
}
