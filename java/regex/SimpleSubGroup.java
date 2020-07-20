import java.util.regex.*;
public class SimpleSubGroup
{
  public static void main(String arg[])
  {
Pattern p = Pattern.compile("B(on)d");

    String candidate = "My name is Bond. James Bond.";
    Matcher matcher = p.matcher(candidate);
    if (matcher.find()) 
    {
      String tmp = matcher.group(0);
      System.out.println(tmp);
      
      System.out.println(matcher.group(1));
    }
  }
}
