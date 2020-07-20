import java.net.*;

class MyAddress6 {

  public static void main (String args[]) {

    try {
      InetAddress thisComputer = InetAddress.getLocalHost();
      byte[] address = thisComputer.getAddress();
      System.out.print("My address is ");
      for (int i = 0; i < address.length; i++) {
        int unsignedByte = address[i] < 0 ? address[i] + 256 : address[i];
        System.out.print(unsignedByte + ".");
      }
      System.out.println();
    }
    catch (UnknownHostException e) {
      System.out.println("I'm sorry. I don't know my own address.");
    }

  }

}
