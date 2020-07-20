import java.util.Scanner;       
class caesar{

  public static String cipherer(String[] alphabet, String character, int shift){
    for(int x = 0; x <= 25; x = x+1) {
      if (character == alphabet[x]) {
        if ((x + shift) < 26) { 
          System.out.println(x + shift);
          return alphabet[x+shift] ; 
        }
        else {
          return alphabet[x+shift-26];
        }
      }   
      else {
      }
    }
    return "ERROR";
  } 


  public static void main (String[] args) {
    String[] alphabet = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};
    String message = "this is a secret code";
    int shift = 13;
    String a = "d";
    String b = "e";
    String c = "n";
    String sa = cipherer(alphabet, a, shift);
    String sb = cipherer(alphabet, b, shift);
    String sc = cipherer(alphabet, c, shift);

    System.out.println(sa);
    System.out.println(sb);
    System.out.println(sc);

  }
}
