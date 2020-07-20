import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import javax.print.event.PrintJobListener;

public class ThreadPoolTest {
    public static void main(String args[]){
        ExecutorService es = Executors.newFixedThreadPool(2);
        

        for(int i=1; i<=10; i++){
            es.submit(new Processor(i));
        }

        es.shutdown();

        System.out.println("All tasks submitted");

        try{
            es.awaitTermination(1, TimeUnit.DAYS);
        }catch(Exception ex){}

        System.out.println("All tasks completed");
    }
}


class Processor implements Runnable {
    private int id;
    Processor(int id){
        this.id = id;
    }

    public void run() {
        System.out.println("started   :: " + this.id);
        int sec = 0;
        try{
            if (id % 2 == 0){
                Thread.sleep(2000);
                sec = 2;
            }else{
                Thread.sleep(1000);
                sec = 1;
            }
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
        System.out.println("completed   :: " + this.id + "  completed in " + sec + "   seconds ");
    }
}