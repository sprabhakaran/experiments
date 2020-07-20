public class PrintThread extends Thread
{
  String ch;
  PrintThread(String ch)
  {
    this.ch = ch;
  }
  public void run()
  {
    for(int i=0;i<1000;i++)
    {
      System.out.print(ch);
    }
  }

  public static void main(String arg[]) throws Exception
  {
    PrintThread pt = new PrintThread("Y");
    PrintThread pt1 = new PrintThread("X");
    PrintThread pt2 = new PrintThread("Z");
    pt.setDaemon(true);
    pt.sleep(1000);
    pt.start();
    pt1.start();
    pt2.start();
    for(int i=0; i< 1000;i++)
    {
      System.out.print("M");
    }
  }
}
