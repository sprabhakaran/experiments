
interface Sayable {
    public void say(String s);
}

public class MethodRef {

    private static String saySomething() {
        System.out.println("I say something.");
        return "";
    }
    public static void main (String args[]) {
        // Sayable s = MethodRef::saySomething;
        // s.say();
        // StaticClass.call(MethodRef::saySomething);
        Sayable s = StaticClass::new;
        s.say("1000");
    }
}

class StaticClass {

    StaticClass(String s){
        System.out.println("-----  " + s);
    }

    public static void call(Sayable s) {
        s.say("1111111111");
    }
     
}