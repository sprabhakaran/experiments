import java.util.*;
import java.util.regex.*;
public class RegexTest1
{
  public static void main(String arg[])
  {
    String pat = arg[0];
    String data = arg[1];
    Pattern p = Pattern.compile(pat);
    Matcher m = p.matcher(data);
    while(m.find())
    {
      System.out.print("Start index: " + m.start());
      System.out.print(" End index: " + m.end() + " ");
      System.out.println(m.group());
    }
  }
}
