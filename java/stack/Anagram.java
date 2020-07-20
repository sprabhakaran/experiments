import java.util.Arrays;

public class Anagram
{
    public static void main(String[] args)
    {
        if (args.length != 2) {
            System.out.println("You did not enter two words!");
        }

        sameChars(args[0], args[1]);        
        printWords(args[0], args[1]);             
    }

    public static boolean sameChars(String wordOne, String wordTwo) 
    {
        lettersOnly(wordOne);
        lettersOnly(wordTwo);      

        char[] first = wordOne.toLowerCase().toCharArray();
        char[] second = wordTwo.toLowerCase().toCharArray();
        Arrays.sort(first);
        Arrays.sort(second);

        if (Arrays.equals(first, second))
            return true;
        else
            return false;
    }

    public static String lettersOnly(String word) 
    {
        int length = word.length();
        StringBuilder end = new StringBuilder(length);
        char x;

        for (int i = (length - 1); i >= 0; i--) {
            x = word.charAt(i);
            if (Character.isLetter(x)) {
                end.append(x);
            }
        }
        return end.toString();
    }

    public static void printWords(String wordOne, String wordTwo)
    {
       if (sameChars(wordOne, wordTwo) == true) {
            System.out.println(wordOne + " is an anagram of "+ wordTwo);
        }

       if (sameChars(wordOne, wordTwo) == false) {
            System.out.println(wordOne + " is not an anagram of "+ wordTwo);
        }
    }

}
