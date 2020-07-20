import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class NewSocket {

  public static void main(String args[]) {
    try {
      Socket socket = new Socket("localhost", 23);
    } catch (UnknownHostException e) {
      System.out.println(e);
    } catch (IOException e2) {
      System.out.println(e2);
    }
  }
}
