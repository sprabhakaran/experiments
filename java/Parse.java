import java.util.regex.*;
public class Parse
{
  public static void main ( String arg[])
  {
    String s = "[Rebranding].[Product Type-wise SalesCost]##[Rebranding].[Product Type-wise SalesCost by Market]";
    Pattern pat = Pattern.compile("(\\[([^\\]]+)\\]\\.\\[?([^\\]]+)\\])");    //No I18N 
    Matcher mat = pat.matcher(s);

    while(mat.find())
    {
      String dbName = mat.group(2).trim();    //dbname
      String viewName = mat.group(3).trim();    //view name

      System.out.println(dbName + "      "+ viewName);
      /*Set<String> viewsList = dbVsView.get(dbName);
      if(viewsList == null)
      {
        viewsList = new HashSet<String>();
      }
      viewsList.add(viewName);
      dbVsView.put(dbName, viewsList);
      */
    }
  }
}
