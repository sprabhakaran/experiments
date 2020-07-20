import java.io.*;
public class ThreadName extends Thread
{
  public void run()
  {
    try
    {
    File f = new File("aa.txt");
    while(!f.exists())
    {
      System.out.println("File not found!!");
      join(1000);
    }
    }catch(Exception e)
    {
    }
    System.out.println("File found!!");
  }
  public static void main(String arg[]) throws Exception
  {
    ThreadName tn1 = new ThreadName();
    tn1.start();

  }
}
