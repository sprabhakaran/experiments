import java.net.*;

class Macfac {

  public static void main (String args[]) {

    try {
      InetAddress macfaq = InetAddress.getByName("reports.zoho.com");
      InetAddress spacecadet = InetAddress.getByName("reports.zoho.com");
      if (macfaq.equals(spacecadet)) 
      { 
        System.out.println ("www.macfaq.com is the same as spacecadet.cnet.com");
      }
      else 
      {
        System.out.println ("www.macfaq.com is not the same as spacecadet.cnet.com");
      }
    }
    catch (UnknownHostException e) {
      e.printStackTrace();
      System.out.println("Host lookup failed.");
    }

  }

}
