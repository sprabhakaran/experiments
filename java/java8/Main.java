import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main (String[] args){
        List<String> names = Arrays.asList("aa", "anna", "zzzz", "bbb", "yyy");

        Collections.sort(names, (String a, String b) -> {return a.compareTo(b); });

        System.out.println(names);

        List<String> names1 = Arrays.asList("aa", "anna", "zzzz", "bbb", "yyy");
        names1.sort((a, b) -> {return a.compareTo(b); });
        System.out.println(names1);
    }
}

class Person implements InterfaceTest {

    public void print(){
        System.out.println("void printed");
    }

    // public int getInt(){
    //     return 100;
    // }

}