import java.net.URLEncoder;


public class EncodeTest {

  public static void main(String args[]) {

    System.out.println(URLEncoder.encode("This string has spaces"));
    System.out.println(URLEncoder.encode("This*string*has*stars"));
    System.out.println(URLEncoder.encode("This%string%has%percent%signs"));
    System.out.println(URLEncoder.encode("This+string+has+pluses"));
    System.out.println(URLEncoder.encode("This/string/has/slashes"));
    System.out.println(URLEncoder.encode("This\"string\"has\"quote\"marks"));
    System.out.println(URLEncoder.encode("This:string:has:colons"));
    System.out.println(URLEncoder.encode("This.string.has.periods"));
    System.out.println(URLEncoder.encode("This=string=has=equals=signs"));
    System.out.println(URLEncoder.encode("This&string&has&ampersands"));

  }

}
