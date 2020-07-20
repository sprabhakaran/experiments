import java.util.*;
import java.net.*;

public class IPAddrRange {
  public static void main(String[] args) {
    try 
    {
      long start = host2long("192.168.1.164");
      long end = host2long("192.168.1.168");
      for (long i=start; i<=end; i++) {
        System.out.println(long2dotted(i));
      }
    } 
    catch (Exception e) {
      e.printStackTrace();
    }
    int x = 10;
    System.out.println(""+(!x));
  }


  public static long ip2long(InetAddress ip) {
    long l=0;
    byte[] addr = ip.getAddress();
    if (addr.length == 4) { //IPV4
      for (int i=0;i<4;++i) {
        l += (((long)addr[i] &0xFF) << 8*(3-i));
      }
    } else { //IPV6
      return 0;  // I dont know how to deal with these
    }
    return l;
  }


  public static long host2long(String host) {
    long ip=0;
    if (!Character.isDigit(host.charAt(0))) return -1;
    int[] addr = ip2intarray(host);
    if (addr == null) return -1;
    for (int i=0;i<addr.length;++i) 
    {
      ip += ((long)(addr[i]>=0 ? addr[i] : 0)) << 8*(3-i);
    }
    return ip;
  }

  public static int[] ip2intarray(String host) {
    int[] address = {-1,-1,-1,-1};
    int i=0;
    StringTokenizer tokens = new StringTokenizer(host,".");
    if (tokens.countTokens() > 4) return null;
    System.out.println("----  " + tokens.countTokens());
    while (tokens.hasMoreTokens()) {
      try {
        int x = Integer.parseInt(tokens.nextToken()) & 0xFF;
        System.out.println("::: " + x);
        address[i++] = x;
      } 
      catch(NumberFormatException nfe) 
      {
        return null;
      }
    }
    return address;
  }

  public static String long2dotted(long address) {
    StringBuffer sb = new StringBuffer();
    for (int i = 0, shift = 24; i < 4; i++, shift -= 8) {
      long value = (address >> shift) & 0xff;
      sb.append(value);
      if (i != 3) {
        sb.append('.');
      }
    }
    return sb.toString();
  }

} 
