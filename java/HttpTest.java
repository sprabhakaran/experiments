import org.apache.commons.httpclient.*;
import org.apache.commons.httpclient.methods.PostMethod;
public class Test
{
  public static void main(String arg[]) throws Exception
  {
    String url = "https://accounts.csez.zohocorpin.com/login";
    HttpClient client = new HttpClient();
    HttpConnectionManager conn = new SimpleHttpConnectionManager(true);
    conn.getParams().setConnectionTimeout(6000);
    client.setHttpConnectionManager(conn);

    PostMethod pm = new PostMethod(url);
    pm.addParameter("LOGIN_ID","prabhakaran");
    pm.addParameter("PASSWORD","123");
    pm.addParameter("FROM_AGENT","true");
    pm.addParameter("servicename","ZohoReports");


    int status =  client.executeMethod(pm);

    System.out.println("PM.  :: " + pm.getResponseBodyAsString());

    System.out.println(status);


  }
}
