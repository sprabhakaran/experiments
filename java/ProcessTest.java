import java.util.*;
import java.io.*;
public class ProcessTest
{
  public static void main ( String arg [] ) throws Exception
  {
    ProcessBuilder pb2=new ProcessBuilder("/usr/bin/hadoop", "fs", "-copyFromLocal", "/home/likewise-open/ZOHOCORP/prabha-1145/Documents/java/log.txt","./");
    pb2.redirectErrorStream(true);
    Process p2=pb2.start();
    InputStreamReader isr2 = new  InputStreamReader(p2.getInputStream());
    BufferedReader br2 = new BufferedReader(isr2);
    String lineRead2;
    while ((lineRead2 = br2.readLine()) != null) 
    {
      System.out.println(lineRead2);
    }
    p2.waitFor();
  }
}
