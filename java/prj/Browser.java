package browser;
import javax.swing.*;
import java.awt.*;
class Browser extends JFrame
{

  private void setMinimumSize()
  {
    this.setMinimumSize(200,200);
  }

  private void setMinimumSize(int height, int width)
  {
    super.setMinimumSize(new Dimension(height,width));
  }
  
  private void setBrowserTitle(String title)
  {
    if(title == null) title = "File Browser";
    super.setTitle(title);
  }
  
  private void basicFrameSetup()
  {
    setBrowserTitle(null);
    pack();
    setMinimumSize();
    setVisible(true);
    setDefaultCloseOperation(EXIT_ON_CLOSE);
  }

  private void setMenubar()
  {
    JMenu menu = new JMenu("test");
    JMenuBar menubar = new JMenuBar();
    menubar.add(menu);
    JPanel panel = new JPanel();
    panel.add(menubar);
    add(panel);
  }
  
  void init()
  {
    basicFrameSetup();
    setMenubar();
  }
}
