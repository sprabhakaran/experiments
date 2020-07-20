import java.util.concurrent.ArrayBlockingQueue;

import com.oracle.jrockit.jfr.Producer;

public class ConsumerProducer {
    public static void main(String args[]){
        Processor p = new Processor();

        Thread t1 = new Thread(new Runnable(){
        
            @Override
            public void run() {
                try{
                    p.produce();
                }catch(Exception ex){}
            }
        });

        Thread t2 = new Thread(new Runnable(){
        
            @Override
            public void run() {
                try{
                    p.consume();
                }catch(Exception ex){}
            }
        });

        Thread t3 = new Thread(new Runnable(){
        
            @Override
            public void run() {
                try{
                    p.sleeper();
                }catch(Exception ex){}
            }
        });

        t1.start();
        t2.start();
        t3.start();

        try{
            t1.join();
            t2.join();
            t3.join();
        }catch(Exception ex){
            ex.printStackTrace();   
        }
    }    
}

class Processor {
    private Integer mutex = new Integer(10);
    public void produce() throws InterruptedException{
        System.out.println("Produce method called");
        Thread.sleep(2000);
        synchronized(mutex){
            mutex.notify();
            System.out.println("notified to other thread");
        }
        System.out.println("Produce method completed");
    }

    public void consume() throws InterruptedException{
        System.out.println("Consume method called");
        synchronized(mutex){
            mutex.wait();
            System.out.println("Resumed.");
        }
        System.out.println("Consume method completed");
    }

    public void sleeper() throws InterruptedException{
        System.out.println("Sleeper method called");
        synchronized(mutex){
            mutex.wait();
            System.out.println("Sleeper Resumed.");
        }
        System.out.println("Sleeper  method completed");
    }
}