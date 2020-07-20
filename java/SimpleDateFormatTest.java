import java.text.*;
import java.text.SimpleDateFormat;
import java.util.*;
public class SimpleDateFormatTest
{
   public static void main(String args[]) throws Exception
   {
      Locale[] la = Locale.getAvailableLocales();
      for(Locale le : la)
      {
         System.out.println(le.getLanguage()+" - "+le.getCountry()+" ---- " + le.getDisplayCountry());
         DateFormat df = DateFormat.getDateInstance(DateFormat.MEDIUM,le);
         System.out.println(df.format("02/02/1990"));
      }
   }
} 

