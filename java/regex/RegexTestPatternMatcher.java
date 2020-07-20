import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexTestPatternMatcher {

  public static void main(String[] args) {
    String EXAMPLE_TEST = args[0];
    Pattern pattern = Pattern.compile("([^\"])\\$\\{[a-zA-Z0-9_\\-:]+\\}([^\"])");
    // In case you would like to ignore case sensitivity you could use this
    // statement
    // Pattern pattern = Pattern.compile("\\s+", Pattern.CASE_INSENSITIVE);
    Matcher matcher = pattern.matcher(EXAMPLE_TEST);
    // Check all occurance
    while (matcher.find()) {
      System.out.print("Start index: " + matcher.start());
      System.out.print(" End index: " + matcher.end() + " ");
      System.out.println(matcher.group());
    }
    // Now create a new pattern and matcher to replace whitespace with tabs
    Pattern replace = Pattern.compile("\\s+");
    Matcher matcher2 = replace.matcher(EXAMPLE_TEST);
    System.out.println(matcher2.replaceAll("\t"));
  }
} 
