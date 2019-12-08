
import java.util.ArrayList;
import java.util.List;

public class ListTest {

    public static void main (String args[]) {
        List<String> list = new ArrayList<>();

        list.add("string1");
        list.add("string2");
        list.add("string3");
        list.add("string4");
        list.add("string5");


        list.forEach( el -> { System.out.println(el); });
    }

}