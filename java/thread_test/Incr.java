public class Incr {
    private static volatile int x = 0;

    private synchronized static void incr(){
        x++;
    }

    public static void main(String args[]) {
        Incr in = new Incr();

        Thread t1 = new Thread(new Runnable(){
            public void run() {
                for (int i=0; i<1000; i++){
                    incr();
                }
            }
        });

        Thread t2 = new Thread(new Runnable(){
            public void run() {
                for (int i=0; i<1000; i++){
                    incr();
                }
            }
        });

        t1.start();
        t2.start();
        
        try{
            t1.join();
            t2.join();
        }catch(Exception ex){
            ex.printStackTrace();
        }

        System.out.println("x is ::  " + x);
    }
}
