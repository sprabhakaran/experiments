import java.net.*;
public class ReverseTest {

  public static void main (String args[]) {

    byte[] xcluster = {18, 81, 0, 21};
    try {
      InetAddress ia = InetAddressFactory.newInetAddress(xcluster);
      System.out.println(ia.getHostName());
    }
    catch (Exception e) {
      System.err.println(e);
    }

    String sunsite = "152.2.22.3";
    try {
      InetAddress ia = InetAddressFactory.newInetAddress(sunsite);
      System.out.println(ia.getHostName());
    }
    catch (Exception e) {
      System.err.println(e);
    }

  }

}
