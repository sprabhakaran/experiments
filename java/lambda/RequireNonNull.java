import java.util.Objects;

public class RequireNonNull {
    public static void main (String args[]) {

        Object obj = null;

        Objects.requireNonNull(obj);

    }
}