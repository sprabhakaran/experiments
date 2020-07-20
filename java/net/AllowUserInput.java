import java.net.*;
import java.io.IOException;

public class AllowUserInput {

  public static void main(String[] args) {

    URL u;
    URLConnection uc;

    try {
      u = new URL("http://www.ora.com");
      try {
        uc = u.openConnection();
        if (!uc.getDoInput()) {
          uc.setDoInput(true);
        }
      }
      catch (IOException e) {
        System.err.println(e);
      }
    }
    catch (MalformedURLException e) {
      System.err.println(e);
    }

  }

}

