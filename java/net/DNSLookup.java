// Print out DNS Record for an Internet Address
import javax.naming.directory.Attributes;
import javax.naming.directory.InitialDirContext;
import javax.naming.NamingEnumeration;
import javax.naming.NamingException;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class DNSLookup
{
  public static void main(String args[])
  {
    try
    {
      InetAddress inetAddress = InetAddress.getByName(args[0]);
      System.out.println(inetAddress.getHostName() + "/" + inetAddress.getHostAddress());
    }
    catch (UnknownHostException exception)
    {
      System.err.println("ERROR: No Internet Address for '" + args[0] + "'");
    }
  }
}
