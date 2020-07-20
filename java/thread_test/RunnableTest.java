
public class RunnableTest {

    public static void main(String args[]) {
        for(int i=0 ;i<10; i++){
            Thread t = new Thread(new Runner(i));
            t.start();
        }
    }
}


class Runner implements Runnable {
    private int idx;
    public Runner(int idx){
        this.idx = idx;
    }

    public void run() {
        for (int i=0; i<10; i++){
            System.out.println("idx ::  "+ idx +"  i  :: "  + i);

            try{
                Thread.sleep(500);
            }catch(Exception ex){
                ex.printStackTrace();
            }
        }
    }
}