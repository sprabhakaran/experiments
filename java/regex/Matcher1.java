import java.util.regex.*;
public class Matcher1
{
  public static void main(String arg[])
  {
    Pattern p = Pattern.compile("(((([0-9]{1,3})(\\.?)){4}(-?)){2}(,?))+");
    String pp = "(((([0-9]{1,3})(\\.?)){4}(-?)){2}(,?))+";
    String data = "192.168.5-192.168.5.100,192.168.5.100-192.168.5.100";
    Matcher m = p.matcher(data);
    System.out.println(data.matches(pp));
  }
}
