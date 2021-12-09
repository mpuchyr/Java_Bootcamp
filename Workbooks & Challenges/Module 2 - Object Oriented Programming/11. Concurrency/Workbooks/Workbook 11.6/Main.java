import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReentrantLock;

public class Main {
 
    static String[] files = new String[] { "data/sales1.csv", "data/sales2.csv", "data/sales3.csv"};
   
    static int sampleSize = 0;
    static int quantitySold = 0;


    public static void main(String[] args) throws Exception {
     
            // execute tasks here
            int numOfThreads = Runtime.getRuntime().availableProcessors();
            CountDownLatch latch = new CountDownLatch(files.length);
            ReentrantLock lock = new ReentrantLock();
            ExecutorService executor = Executors.newFixedThreadPool(numOfThreads);
            for (String string : files) {
                executor.submit(() -> increment(string, latch, lock));
            }

            Scanner scan = new Scanner(System.in);
            System.out.print("Please enter your name to access the Global Superstore data: ");
            String name = scan.nextLine();
            System.out.println("\nThank you " + name + ".\n");
            scan.close();

            latch.await();
            executor.shutdown();

            System.out.println("Sample size: " + sampleSize);
            System.out.println("Quantity Sold: " + quantitySold);
            
     
    }

    public static void increment (String file, CountDownLatch latch, ReentrantLock lock) {     
        try {
            Path path = Paths.get(Thread.currentThread().getContextClassLoader().getResource(file).toURI());
            Files.lines(path)
            .skip(1)
            .mapToInt((line) -> Integer.parseInt(line.toString().split(",")[2]))
            .forEach((quantity) -> {
                lock.lock();
                quantitySold += quantity;
                sampleSize++;
                lock.unlock();
            });
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        latch.countDown();

    }

}
