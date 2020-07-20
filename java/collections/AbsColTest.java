import java.util.*;
public class AbsColTest
{
  public static void main(String arg[])
  {
    Test t = new Test();
    t.add("aaaa");
    System.out.println(t);
  }
}
class Test<E> extends AbstractCollection
{
   public Iterator<E> iterator()
   {
     return new Iterator<E>(){
       public boolean hasNext()
       {
         return true;
       }
       public E next()
       {
         return this;
       }
       public void remove()
       {
       }
     };
   }

   public int size()
   {
     return 0;
   }
}
