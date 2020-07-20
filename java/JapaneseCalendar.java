import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Insets;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.text.DateFormat;
import java.text.DateFormatSymbols;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import javax.swing.BorderFactory;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class JapaneseCalendar extends JPanel {
  public JapaneseCalendar() {
    setLayout(new BorderLayout());
    final CalendarPane cp = new CalendarPane(Locale.JAPANESE);
    add(cp, BorderLayout.NORTH);
  }

  public static void main(String[] a) {
    JFrame f = new JFrame();

    f.add(new JapaneseCalendar());
    f.pack();
    f.setVisible(true);
  }
}

class CalendarPane extends JPanel {
  final static Locale JAPAN_IMP_ERA = new Locale("ja", "JP", "JP");

  private Locale locale;
  CalendarPane(Locale initLocale) {
    setPreferredSize(new Dimension(400, 400));
    locale = initLocale;
  }

  public void paintComponent(Graphics g) {
    int width = 400;
    int height = 400;

    Calendar cal = Calendar.getInstance(locale);
    cal.setTime(new Date());

    String header = cal.getDisplayName(Calendar.MONTH, Calendar.LONG, locale);
    header += " " + cal.get(Calendar.YEAR);

    FontMetrics fm = g.getFontMetrics();
    Insets insets = getInsets();
    g.setColor(Color.black);
    g.drawString(header, (width - fm.stringWidth(header)) / 2, insets.top + fm.getHeight());

    DateFormatSymbols dfs = new DateFormatSymbols(locale);
    String[] weekdayNames = dfs.getShortWeekdays();
    int fieldWidth = (width - insets.left - insets.right) / 7;
    g.drawString(weekdayNames[Calendar.SUNDAY], insets.left
        + (fieldWidth - fm.stringWidth(weekdayNames[Calendar.SUNDAY])) / 2, insets.top + 3
        * fm.getHeight());
    g.drawString(weekdayNames[Calendar.MONDAY], insets.left + fieldWidth
        + (fieldWidth - fm.stringWidth(weekdayNames[Calendar.MONDAY])) / 2, insets.top + 3
        * fm.getHeight());
    g.drawString(weekdayNames[Calendar.TUESDAY], insets.left + 2 * fieldWidth
        + (fieldWidth - fm.stringWidth(weekdayNames[Calendar.TUESDAY])) / 2, insets.top + 3
        * fm.getHeight());
    g.drawString(weekdayNames[Calendar.WEDNESDAY], insets.left + 3 * fieldWidth
        + (fieldWidth - fm.stringWidth(weekdayNames[Calendar.WEDNESDAY])) / 2, insets.top + 3
        * fm.getHeight());
    g.drawString(weekdayNames[Calendar.THURSDAY], insets.left + 4 * fieldWidth
        + (fieldWidth - fm.stringWidth(weekdayNames[Calendar.THURSDAY])) / 2, insets.top + 3
        * fm.getHeight());
    g.drawString(weekdayNames[Calendar.FRIDAY], insets.left + 5 * fieldWidth
        + (fieldWidth - fm.stringWidth(weekdayNames[Calendar.FRIDAY])) / 2, insets.top + 3
        * fm.getHeight());
    g.drawString(weekdayNames[Calendar.SATURDAY], insets.left + 6 * fieldWidth
        + (fieldWidth - fm.stringWidth(weekdayNames[Calendar.SATURDAY])) / 2, insets.top + 3
        * fm.getHeight());

    int dom = cal.get(Calendar.DAY_OF_MONTH);
    cal.set(Calendar.DAY_OF_MONTH, 1);
    int col = 0;
    switch (cal.get(Calendar.DAY_OF_WEEK)) {
    case Calendar.MONDAY:
      col = 1;
      break;

    case Calendar.TUESDAY:
      col = 2;
      break;

    case Calendar.WEDNESDAY:
      col = 3;
      break;

    case Calendar.THURSDAY:
      col = 4;
      break;

    case Calendar.FRIDAY:
      col = 5;
      break;

    case Calendar.SATURDAY:
      col = 6;
    }
    cal.set(Calendar.DAY_OF_MONTH, dom);

    int row = 5 * fm.getHeight();
    for (int i = 1; i <= cal.getActualMaximum(Calendar.DAY_OF_MONTH); i++) {
      g.drawString("" + i, insets.left + fieldWidth * col + (fieldWidth - fm.stringWidth("" + i))
          / 2, row);
      if (++col > 6) {
        col = 0;
        row += fm.getHeight();
      }
    }
  }
}
