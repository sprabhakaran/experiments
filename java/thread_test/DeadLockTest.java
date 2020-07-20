import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.Lock;

public class DeadLockTest {
    public static void main (String args[]){
        Processor p = new Processor();

        Thread t1 = new Thread(new Runnable(){
        
            @Override
            public void run() {
                p.firstMethod();
            }
        });

        Thread t2 = new Thread(new Runnable(){
        
            @Override
            public void run() {
                p.secondMethod();
            }
        });

        t1.start();
        // t2.start();

        try{
            t1.join();
            t2.join( );
        }catch(Exception ex) {

        }

        p.finished();
    }
}

class Processor {

    private Lock lock = new ReentrantLock();

    public void firstMethod(){
        System.out.println("first method called");
        lock.lock();
        System.out.println("first method locked");
        try{
            secondMethod();
        }finally{
            lock.unlock();
            System.out.println("first method unlocked");
        }
    }

    public void secondMethod(){
        System.out.println("Second method called");
        lock.lock();
        lock.lock();
        System.out.println("second mehtod locked");
        try{
            System.out.println("Sleeeping 2 seconds");
            try{
            Thread.sleep(2000);
            }catch(Exception ex){}
        }finally{
            // lock.unlock();
            // System.out.println("second method unlocked");
        }
    }

    public void finished(){

    }
}