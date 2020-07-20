import java.util.logging.*;
public class LoggingTest
{
    private static final Logger logger =
              Logger.getLogger(LoggingTest.class.getName());
  public static void main ( String arg [] )
  {
    
    logger.entering(LoggingTest.class.getName(), "doIt");

  }
}
