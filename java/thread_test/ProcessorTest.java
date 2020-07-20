import java.util.Scanner;

public class ProcessorTest {
    public static void main(String args[]){
        Processor p = new Processor();
        p.start();

        Scanner scan = new Scanner(System.in);
        scan.nextLine();

        p.shutdown();


        scan.nextLine();

        p.start1();
    }
}


class Processor extends Thread {

    private boolean isRunning = true;
    private int i = 0;
    public void run() {
        boolean localvar = isRunning;
        while(localvar){
            System.out.println("processor running " + ++i + "  status  " + (isRunning == localvar));

            try{
                Thread.sleep(1000);
            }
            catch(Exception ex){
                ex.printStackTrace();
            }
        }

    }

    public void shutdown() {
        isRunning = false;
    }

    public void start1(){
        isRunning = true;
    }
}