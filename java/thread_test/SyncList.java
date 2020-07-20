import java.util.*;

public class SyncList {
    private static List<Integer> list;
    public static void main (String args[]){
        SyncList sl = new SyncList();
        list = new ArrayList(2000);
        sl.doWork();
        System.out.println(list.size());
    }

    private void add(int i){
        synchronized(list){
            list.add(i);
        }
    }

    public void doWork(){
        Thread t1 = new Thread(new Runnable(){
            public void run(){
                for(int i=0; i<1000; i++){
                    add(i);
                }
            }
        });

        Thread t2 = new Thread(new Runnable(){
            public void run(){
                for(int i=0; i<1000; i++){
                    add(i);
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
    }
}


