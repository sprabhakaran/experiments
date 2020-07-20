import java.awt.Robot;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.awt.Toolkit;
import java.awt.Rectangle;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JWindow;
public class Main1 
{
  public static void main(String[] argv) throws Exception 
  {
    Dimension screenDim = Toolkit.getDefaultToolkit().getScreenSize();
    Robot robot = new Robot();


    BufferedImage image = robot.createScreenCapture(new Rectangle(0, 0, (int) screenDim.getWidth(),
          (int) screenDim.getHeight()));

    JWindow window = new JWindow(new JFrame());
    window.getContentPane().setLayout(new BorderLayout());
    window.getContentPane().add(BorderLayout.CENTER, new JLabel(new ImageIcon(image)));
    window.pack();
    window.setVisible(true);
  }
}
