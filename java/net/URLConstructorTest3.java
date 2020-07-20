import java.net.*;

public class URLConstructorTest3 {

  public static void main (String args[]) {

    URL webURL, ftpURL;

    try {
      webURL = new URL("http", "www.macfaq.com", 80, "/vendor.html");
      System.out.println(webURL);  
      ftpURL = new URL("ftp", "prabha-1145", 21, "/error.txt");
      System.out.println(ftpURL);
    }
    catch (MalformedURLException e)  {
      System.err.println(e);
    }

  }

}

