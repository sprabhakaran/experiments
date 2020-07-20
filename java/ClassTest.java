import java.io.*;
import java.util.*;
public class ClassTest
{
  public static void main(String arg[]) throws Exception
  {
    File f = new File("aaa.txt");
    BufferedWriter bw = new BufferedWriter(new FileWriter(f, false));
    bw.write("afsfdsdfsdf");
    bw.write("sfsdsdf");
    bw.newLine();
    bw.write("ssdfsdfsdfsf");
    
    bw.flush();
    bw.close();
  }

}
