public class TestClientState {
    public static void main(String[] args) {

      int i = 0;
      System.out.println();

        final StateContext sc = new StateContext();
        sc.writeName("Monday");
        sc.writeName("Tuesday");
        sc.writeName("Wednesday");
        sc.writeName("Thursday");
        sc.writeName("Friday");
        sc.writeName("Saturday");
        sc.writeName("Sunday");
    }
}
class StateContext {
    private Statelike myState;
    StateContext() {
        setState(new StateA());
    }
    void setState(final Statelike newState) {
        myState = newState;
    }
    public void writeName(final String name) {
        myState.writeName(this, name);
    }
}
interface Statelike {
    void writeName(StateContext context, String name);
}
class StateA implements Statelike {
    public void writeName(final StateContext context, final String name) {
        System.out.println(name.toLowerCase());
        context.setState(new StateB());
    }
}
class StateB implements Statelike {
    private int count = 0;
    public void writeName(final StateContext context, final String name) {
        System.out.println(name.toUpperCase());
        if(++count > 1) {
            context.setState(new StateA());
        }
    }
}

