import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.Condition;

public class ReentrantLockTest {
    public static void main (String args[]) {
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
        t2.start();

        try{
            t1.join();
            t2.join();
        }catch(Exception ex){

        }

        System.out.println("Count is : " + p.getCount());
    }
}

class Processor {

    private int cnt = 0;

    Lock lock = new ReentrantLock();
    Condition cont = lock.newCondition();

    public void increment() {
        for(int i=0; i<10000; i++) {
            cnt++;
        }
    }

    public void firstMethod() {
        lock.lock();
        System.out.println("first method locked");
        
        try{
            cont.await();
        }catch(Exception ex) {}

        System.out.println("first method awoken");
        try{
            increment();
        }finally{
            lock.unlock();
        }
        System.out.println("First method completed");
    }

    public void secondMethod() {
        try{
            System.out.println("Sleeping ...");
            Thread.sleep(2000);
        }catch(Exception ex){}

        System.out.println("Second method locked");
        lock.lock();

        System.out.println("Signaling ...");
        cont.signal();

        try{
            increment();
        }finally{
            lock.unlock();
        }
        System.out.println("Second method completed");
    }

    public int getCount(){
        return this.cnt;
    }
}