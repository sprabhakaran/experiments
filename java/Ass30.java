import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Ass30 extends JFrame implements ActionListener
{
    JLabel textLabel, findLabel, replaceLabel, occurrenceLabel;


    JTextArea text;
    JTextField findText, replaceText, occurrenceText;
    JButton find, replace, exit;
    JPanel pan1,pan2;
    int occurrences=0,i=0;

    public Ass30()
    {
        textLabel = new JLabel("Enter Text:",JLabel.RIGHT);
        findLabel = new JLabel("Text to Find:",JLabel.RIGHT);
        replaceLabel = new JLabel("Text to Replace:",JLabel.RIGHT);
        occurrenceLabel = new JLabel("No.of Occurrences:",JLabel.RIGHT);

        text = new JTextArea(1,20);
        findText = new JTextField(20);
        replaceText = new JTextField(20);
        occurrenceText = new JTextField(20);

        pan1 = new JPanel();
        pan1.setLayout(new GridLayout(4,2));
        pan1.add(textLabel);
        pan1.add(text);
        pan1.add(findLabel);
        pan1.add(findText);
        pan1.add(replaceLabel);
        pan1.add(replaceText);
        pan1.add(occurrenceLabel);
        pan1.add(occurrenceText);

        find = new JButton("Find");
        replace = new JButton("Replace");
        exit = new JButton("Exit");

        find.addActionListener(this);
        replace.addActionListener(this);
        exit.addActionListener(this);

        pan2 = new JPanel();
        pan2.setLayout(new FlowLayout());
        pan2.add(find);
        pan2.add(replace);
        pan2.add(exit);
        add(pan1,"Center");
        add(pan2,"South");

        setTitle("Find And Replace");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args)
    {
        new Ass30();
    }

    public void actionPerformed(ActionEvent ae)
    {
        JButton btn = (JButton)ae.getSource();
        if(btn == find)
        {
            String s = text.getText();
            String f = findText.getText();
            i = s.indexOf(f);
            if(i!=-1)
            {
                occurrences++;
                occurrenceText.setText(Integer.toString(occurrences));
                text.select(i,i+f.length());
                text.requestFocus();

            }
        }
        if(btn == replace)
        {
            if(text.getSelectedText().length()!=0)
            {
                String r = replaceText.getText();
                text.replaceSelection(r);
            }
        }
        if(btn == exit)
        {
            System.exit(0);
        }
    }
}
