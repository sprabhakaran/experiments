public class ThreadTest {

    public static void main(String args[]){
        Thread t1 = new Main(1000);
        t1.run();
        
        Thread t2 = new Main(500);
        t2.run();
        
        System.out.println(t1.getName());
        System.out.println(t2.getName());
        
    }
}


class Main extends Thread {
    private static int i = 0;
    private int s;
    Main(int s){
        this.s = s;
    }
    public void run(){
        for(int i=0; i<10; i++) {
            try{
                Thread.sleep(s);
            }catch(Exception ex){
                ex.printStackTrace();
            }
            System.out.println(this.getName() + " :: " + i);
        }
    }
}