
public class ConstRef {
    public static void main (String args[]) {
        Sayable s = StaticClass::new;
        s.say("1000");
    }
}

interface Sayable {
    public void say(String s);
}

class StaticClass {

    StaticClass(String s){
        
    }

    public static void call(Sayable s) {
        s.say("1111111111");
    }
     
}