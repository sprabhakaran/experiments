import java.io.*;
import java.util.regex.*;
public class MatcherTest
{
  public static void main(String arg[]) throws Exception
  {
    String data = getAsString("/home/local/ZOHOCORP/prabha-1145/workspace/top/zohodb/build/ZOHODB/pkg/AdventNet/ZohoDB/conf/fileslist/ColorMapping.html");
    Pattern p = Pattern.compile("bgcolor=\"#(\\w{6})\".*?bgcolor=\"#(\\w{6})\"");
    Matcher match = p.matcher(data);
    System.out.println(match.groupCount());
    /*while(match.find())
    {
      System.out.println(match.group(3).toLowerCase());
    }*/
  }

  public static String getAsString(String path) throws Exception
  {
    File f = new File(path);
    FileReader fr = new FileReader(f);
    BufferedReader br = new BufferedReader(fr);
    StringBuffer sb = new StringBuffer();
    while(br.ready())
    {
      sb.append(br.readLine());
    }
    return sb.toString();
  }

}
