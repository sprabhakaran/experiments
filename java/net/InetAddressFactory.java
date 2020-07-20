import java.util.StringTokenizer;
import java.net.*;
public class InetAddressFactory {

  // Use a byte array like {(byte) 199, (byte) 1, (byte) 32, (byte) 90} 
  // to build an InetAddressObject   

  // Use a String like 199.1.32.90 to build
  // an InetAddressObject
  public static InetAddress newInetAddress(String s) 
    throws UnknownHostException {

    // be ready for IPv6
    int num_bytes_in_an_IP_address = 4;
    byte addr[] = new byte[num_bytes_in_an_IP_address];
    StringTokenizer st = new StringTokenizer(s, ".");

    // make sure the format is correct
    if (st.countTokens() != addr.length) {
      throw new UnknownHostException(s 
          + " is not a valid numeric IP address");
    }

    for (int i = 0; i < addr.length; i++) {
      int thisByte = Integer.parseInt(st.nextToken());
      if (thisByte < 0 || thisByte > 255) {
        throw new UnknownHostException(s 
            + " is not a valid numeric IP address");
      }

      // check this
      if (thisByte > 127) thisByte -= 256;
      addr[i] = (byte) thisByte;

    }  // end for

    return newInetAddress(addr);

  } // end newInetAddress            

} // end InetAddressFactory 

