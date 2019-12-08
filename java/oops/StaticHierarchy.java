
class TestClass {

    public static void parent( ) {
        System.out.println("Parent classes method called ");
    }

}
public class StaticHierarchy extends TestClass {

    public static void main (String args[]) {
        parent();
    }

}