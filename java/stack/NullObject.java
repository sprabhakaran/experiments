class CallAnother
{
   CallAnother(int i)
   {
      System.out.println("Object create successfully");
   }
}
public class NullObject
{
   public static void main(String arg[])
   {
      CallAnother ca = new CallAnother(-1);
   }
}
