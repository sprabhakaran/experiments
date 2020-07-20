import java.util.Arrays;

public class IPAddressTest {
  public static void main(String args[]){
    String testString = "130.191.208.70";
    IPAddress ipAdd = new IPAddress(testString);
    System.out.println(ipAdd);

    ipAdd.gettmpString();

  }
}

