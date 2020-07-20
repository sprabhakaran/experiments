import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.io.*;
public class RegexTestHarness {

  public static String readFileAsString(File file) throws Exception
  {
    return readStreamToString(new FileInputStream(file));
  }
  public static String readStreamToString(InputStream stream) throws java.io.IOException
  {
    BufferedReader br = null;
    StringBuffer sb = new StringBuffer();
    try
    {
      br = new BufferedReader(new InputStreamReader(stream));
      while(br.ready())
      {
        String l = br.readLine();
        sb.append(l).append("\n");
      }
    }
    finally { br.close(); }
    return sb.toString();
  }
  public static void main(String[] args) throws Exception{
      Pattern pattern = Pattern.compile("#(\\w{6})");
      String data = readFileAsString(new File("/home/local/ZOHOCORP/prabha-1145/tt.html"));
      Matcher matcher = pattern.matcher(data);
      matcher.find();
      System.out.println(matcher.group(1));
  }
}
