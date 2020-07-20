import java.net.*;
import java.io.*;

public class postform 
{

  URL u;

  public static void main(String args[]) {
    String s;
    try {
      s = args[0];
    }
    catch (ArrayIndexOutOfBoundsException e) {
      s = "http://hoohoo.ncsa.uiuc.edu/cgi-bin/post-query";
    }

    try {
      postform pf = new postform();
      pf.u = new URL(s);
      pf.submitData();
    }
    catch (MalformedURLException e) {
      System.err.println(args[0] + "is not a URL I understand");
    }
  }


  void submitData() 
  {
    String query = "name=" + URLEncoder.encode("Elliotte Rusty Harold");
    query += "&";
    query += "email=" + URLEncoder.encode("elharo@sunsite.unc.edu");

    int cl = query.length();
    try {
      URLConnection uc = u.openConnection();
      uc.setDoOutput(true);
      uc.setDoInput(true);
      uc.setAllowUserInteraction(false);
      DataOutputStream dos = new DataOutputStream(uc.getOutputStream());
      dos.writeBytes(query);
      dos.close();
      // Read the response
      DataInputStream dis = new DataInputStream(uc.getInputStream());
      String nextline;
      while((nextline = dis.readLine()) != null) {
        System.out.println(nextline);
      }
      dis.close();
    }
    catch (Exception e) {
      System.err.println(e);
    }
  }
}

