import java.io.File;

public class DelDirTest {
    public static void main(String args[]) {
        File f = new File("./a");
        boolean isDel = f.delete();

        System.out.println("delete successfully - is Del " + isDel);

    }
}