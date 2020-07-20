import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.URL;

import javax.swing.JFrame;

public class WAWTest extends JFrame {
  AudioClip click;

  public static void main(String[] args) {
    new WAWTest();
  }

  public WAWTest() {
    this.setSize(400, 400);
    this.setTitle("Mouse Clicker");
    this.addMouseListener(new Clicker());

    URL urlClick = WAWTest.class.getResource("/home/local/ZOHOCORP/prabha-1145/MyHome/mov/VazhakkuEnn.350MB.mkv");
    click = Applet.newAudioClip(urlClick);

    this.setVisible(true);
  }

  private class Clicker extends MouseAdapter {
    public void mouseClicked(MouseEvent e) {
      click.play();
    }
  }
}
