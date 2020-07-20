public class CEncrypt 
{
  static final String key = "test";

  private static String encryptString(String str)
  {
    StringBuffer sb = new StringBuffer (str);

    int lenStr = str.length();
    int lenKey = key.length();


    for ( int i = 0, j = 0; i < lenStr; i++, j++ ) 
    {
      if ( j >= lenKey )
      { 
        j = 0;
      }
      sb.setCharAt(i, (char)(str.charAt(i) ^ key.charAt(j))); 
    }
    return sb.toString();
  }

  private static String decryptString(String str)
  {
    return encryptString(str);
  }


  public static void main(String[] args) 
  {
    String s1 = "Somebody complimented my driving today. There was a note on my car which said \"PARKING FINE\". So that was nice! - Tommy Cooper.";

    String s2 = encryptString(s1);

    String s3 = decryptString(s2);

    System.out.println("Original string:  " + s1);

    System.out.println("Encrypted string: " + s2);

    System.out.println("Decrypted string: " + s3);
  }
}
