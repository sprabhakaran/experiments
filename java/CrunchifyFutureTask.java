import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.Callable;

/**
 * @author Crunchify.com
 * 
 */

public class CrunchifyFutureTask {

  public static void main(String[] args) {
    CrunchifyCallable crunchifyCallable1 = new CrunchifyCallable(2000);
    CrunchifyCallable crunchifyCallable2 = new CrunchifyCallable(4000);

    FutureTask<String> futureTask1 = new FutureTask<String>( crunchifyCallable1);
    FutureTask<String> futureTask2 = new FutureTask<String>( crunchifyCallable2);

    // Creates a thread pool that reuses a fixed number of threads operating
    // off a shared unbounded queue. At any point, at most nThreads threads
    // will be active processing tasks.
    ExecutorService executor = Executors.newFixedThreadPool(2);
    executor.execute(futureTask1);
    executor.execute(futureTask2);

    while (true) {
      try {
        if (futureTask1.isDone() && futureTask2.isDone()) {
          System.out.println("Done");
          // Initiates an orderly shutdown in which previously
          // submitted tasks are executed, but no new tasks will be
          // accepted. Invocation has no additional effect if already
          // shut down.
          executor.shutdown();
          return;
        }

        if (!futureTask2.isDone()) {
          // wait indefinitely for future task to complete
          System.out.println("FutureTask1 output="
              + futureTask1.get());
        }

        System.out.println("Waiting for FutureTask1 to complete");
        String s = futureTask2.get(200L, TimeUnit.MILLISECONDS);
        if (s != null) {
          System.out.println("FutureTask1 output=" + s);
        }
      } catch (Exception e) {
        e.printStackTrace();
      } 
    }
  }
}

class CrunchifyCallable implements Callable<String> {

  private long waitTime;

  public CrunchifyCallable(int time) {
    this.waitTime = time;
  }

  @Override
  public String call() throws Exception {
    Thread.sleep(waitTime);
    return Thread.currentThread().getName();
  }
}
