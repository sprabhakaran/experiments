import java.util.logging.ConsoleHandler;
import java.util.logging.Logger;

public class Main {
  public static void main(String[] argv) throws Exception {
    ConsoleHandler handler = new ConsoleHandler();

    // Add to logger
    Logger logger = Logger.getLogger("com.mycompany");
    logger.addHandler(handler);

    logger.info("Test");
    System.out.println("Guest");
  }
}
