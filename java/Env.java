import java.util.*;
public class Env {
  public static void main (String[] args) 
  {
     System.out.println(System.getProperty("os.name")+" "+System.getProperty("os.version"));
     System.out.println(System.getProperty("java.version"));
     System.out.println(System.getProperty("os.arch"));
  }
}

