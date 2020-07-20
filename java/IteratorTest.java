public class IteratorTest
{
  public static void main ( String arg[])
  {
    IT it = new IT(new String[]{"Item1","Item2","Item3","Item4","Item5","Item6","Item7","Item8",null});
    while(it.hasNext())
    {
      System.out.println(it.next());
    }
  }
}

class IT
{
  int next=-1;
  String[] arr;
  public IT(String[] arr)
  {
    this.arr = arr;
    next=0;
  }
  boolean hasNext()
  {
    return arr.length>0 && next<arr.length;
  }
  String next()
  {
    return arr[next++];
  }
}
