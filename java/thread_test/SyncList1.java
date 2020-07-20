import java.util.*;

public class SyncList1 {
    public static void main (String args[]) {
        new Worker().main();
    }   

}


class Worker {

    private List<Integer> list1 = new ArrayList<Integer>();
    private List<Integer> list2 = new ArrayList<Integer>();

    public void addList1() {
        for(int i=0 ;i <100; i++){
            try{
                Thread.sleep(1);
            }catch(Exception ex){
                ex.printStackTrace();
            }

            list1.add(i);
        }
    }

    public void addList2() {
        for(int i=0 ;i <100; i++){
            try{
                Thread.sleep(50);
            }catch(Exception ex){
                ex.printStackTrace();
            }
            
            list2.add(i);
        }
    }

    public void main() {
        System.out.println("starting ...");

        long start = System.currentTimeMillis();
        Thread t1 = new Thread(new Runnable(){
        
            @Override
            public void run() {
                addList1();
                System.out.println("thread 1 completed ");
            }
        });

        Thread t2 = new Thread(new Runnable(){
        
            @Override
            public void run() {
                addList2();
                System.out.println("thread 2 completed ");
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

        long end = System.currentTimeMillis();


        System.out.println("Time taken :: " + (end-start));
        System.out.println("list 1 size :: " + list1.size()+"   list 2 size ::  " + list2.size());

    }
}