public class StringSearch
{
  private static void indexOf(String orig, String patt)
  {
    int len = orig.length();
    int patLen = patt.length();
    for(int i=0; i<len; i++)
    {
    boolean flag = false;
      if(flag)
      {
        System.out.println("String founded");
      }
      char start = patt.charAt(0);
      char matchCh = orig.charAt(i);
      System.out.println(start+"  "+matchCh);
      if(start == matchCh)
      {
        System.out.println("Match character  :: " + start);
        for(int j=1; j<patLen; j++)
        {
          if(patt.charAt(j) == orig.charAt(i+j))
          {
            flag = true;
          }
          else
          {
            flag = false;
          }
        }
      }
    }
  }
  public static void main(String arg[])
  {
    String orig = "This is String";
    String patt = "his";
    indexOf(orig,patt);
  }

}
