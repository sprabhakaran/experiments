
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * $Id$
 * @author gramkumar-0817
 *
 */
public class ProcessUtil extends Thread {

  public void run() {
    ArrayList al = new ArrayList();
    al.add("sh");
    al.add("test.sh");
    executeCommand(al);
  }
  public static int executeCommand(List<String> command) {
    BufferedReader br = null;
    int status = -1;
    try {
      ProcessBuilder pb = new ProcessBuilder(command);
      pb.directory(directory);
      pb = pb.redirectErrorStream(true);

      Process p = pb.start();
      br = new BufferedReader(new InputStreamReader(p.getInputStream()));
      String line;
      while((line = br.readLine()) != null) {
        //LoggerUtil.debug(null, line);
        System.out.println(line);
      }

      //status = p.waitFor();
      System.out.println("I am here");

    } catch (IOException e) {
      e.printStackTrace();
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      //FileUtils.closeStream(br);
    }
    return status;
  }
  public static void main(String arg[]) throws Exception
  {
    Thread t = new ProcessUtil();
    t.start();
    Thread.sleep(5000);
    System.out.println("I am Out ");
  }
}

