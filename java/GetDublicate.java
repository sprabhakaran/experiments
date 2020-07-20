import java.util.*;
public class GetDublicate
{
   static void getDuplicate(Stack st ,int cnt)
   {
      String s = st.get(cnt);
      if(st.get(cnt++).equals(s));
      {
         System.out.println("yyyyyyyy");
      }
   }
   public static void main(String arg[])
   {

      Stack aa = new Stack();
      aa.push("aaa");
      aa.push("aaa");
      aa.push("bbb");
      aa.push("bbb");
      aa.push("ccc");
      aa.push("ccc");
      aa.push("ddd");
      aa.push("ddd");
      System.out.println(aa.indexOf("bbb"));
      getDuplicate(aa,0);
   }
}
