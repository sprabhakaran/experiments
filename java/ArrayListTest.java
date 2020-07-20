import java.util.ArrayList;
public class ArrayListTest{
    public static void main (String arg[]){
        ArrayList al = new ArrayList();
        int i = 0;
        while(true){
            al.add("  " + i);
            if (i == 100000){
                System.out.println("i is " + i);
            }
            i++;
        }
    }
}
