import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;

public class Main {
    
    static AtomicInteger counter = new AtomicInteger(0);
    
    public static void main(String[] args) {
        
        int numOfThreads = Runtime.getRuntime().availableProcessors();
        ExecutorService executor = Executors.newFixedThreadPool(numOfThreads);
        CountDownLatch latch = new CountDownLatch(55);
        for (int i = 0; i < 55; i++) {
            executor.submit(() -> task(latch));
        }


        try {
            latch.await();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            executor.shutdown();
        }


        System.out.println(counter);
    }
    
    public static void task(CountDownLatch latch) {
        //some really long operations that need to run in the background...
        for (int i = 0; i < 10000; i++) {
            counter.addAndGet(1); // there happens to be a line that updates the counter variable. 
        }
        latch.countDown();
        //more really long operations...
    }
  
}
