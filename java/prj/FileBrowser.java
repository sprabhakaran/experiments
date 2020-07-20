package browser;
import javax.swing.*;
public class FileBrowser extends Browser
{
  public void init()
  {
    super.init();
  }
  public static void main(String arg[])
  {
    SwingUtilities.invokeLater(new Runnable(){
      public void run()
      {
        new FileBrowser().init();
      }
    });
  }
}
