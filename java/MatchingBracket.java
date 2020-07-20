import java.util.*;
public class MatchingBracket
{
  public static void main ( String arg[])
  {
    Stack stack = new Stack();
    String a = arg[0];
    for(int i=0; i<a.length(); i++)
    {
      char ch = a.charAt(i);
      if(ch == '(')
      {
        stack.push(ch);
      }
      else if(ch == ')')
      {
        stack.pop();
      }
    }
    System.out.println(stack);
  }
}
