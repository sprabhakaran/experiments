/*
 * <applet code="ListTest.class" width="300" height="300"> </applet>
 */

import java.awt.*;
import java.applet.*;
import java.awt.event.*;
public class ListTest extends Applet
{
  List acts = new List();
  TextField tx = new TextField(10);
  Button add = new Button("Add");
  String stringlist[] = {"one","two","three"};
  public void start()
  {
    add(new Label("text"));
    add(tx);
    for(int i=0; i<stringlist.length; i++)
    {
      acts.addItem(stringlist[i]);
      add(acts);
      add.addActionListener(new Add());
      add(add);
    }
  }

  class Add implements ActionListener
  {
    public void actionPerformed(ActionEvent e)
    {
      acts.addItem(tx.getText());
    }
  }
}
