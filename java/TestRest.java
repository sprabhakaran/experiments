import java.util.*;
public class TestRest
{
  public static void main(String argg[])
  {
    ArrayList<Object[]> al = new ArrayList<Object[]>();
    al.add(new Object[]{1,"aaa",3});
    al.add(new Object[]{2,"bbb",3});
    al.add(new Object[]{3,"ccc",3});
    al.add(new Object[]{4,"ddd",3});
    al.add(new Object[]{5,"eee",3});

    al.add(new Object[]{1,"aaa",3});
    al.add(new Object[]{2,"bbb",3});
    al.add(new Object[]{3,"ccc",3});
    al.add(new Object[]{4,"ddd",3});
    al.add(new Object[]{5,"eee",3});

    
    System.out.println("Before ...");
    for(Object[] a : al)
    {
      System.out.println(a[0]+"  "+a[1]+"  "+a[2]);
    }
    ArrayList<Object[]> a1 = updateval(al);
    System.out.println("\nUpdated ...");
    for(Object[] a : a1)
    {
      System.out.println(a[0]+"  "+a[1]+"  "+a[2]);
    }
    System.out.println("\nAfter ...");
    for(Object[] a : al)
    {
      System.out.println(a[0]+"  "+a[1]+"  "+a[2]);
    }
    System.out.println(al);
  }

  private static ArrayList updateval(ArrayList<Object[]> al)
  {
    for(Object[] o: al)
    {
      if(o[1].equals("ccc"))
      {
        o[2] = "DDDD";
      }
    }
    return al;
  }

}
