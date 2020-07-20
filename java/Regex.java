import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Regex
{
  public static final String EXAMPLE_TEST = "String String";

  public static void main(String[] args) {
    Pattern pattern = Pattern.compile("\b(\\w+) (\\1)\b");
    Matcher matcher = pattern.matcher(EXAMPLE_TEST);
    while (matcher.find()) 
    {
      System.out.print("Start index: " + matcher.start());
      System.out.println(" End index: " + matcher.end() + " ");
      System.out.println(matcher.group());
    }
  }
} 
