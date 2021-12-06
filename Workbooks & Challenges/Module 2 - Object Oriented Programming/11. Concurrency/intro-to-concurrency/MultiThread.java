public class MultiThread {

    public static void main(String[] args) {
        Thread thread2 = new Thread(() -> longTask());
        thread2.start();

        System.out.println("OH NO, A BIG ERROR OCCURRED IN THE MAIN THREAD. LET'S INTERRUPT THE BACKGROUND THREAD");
        System.out.println("Doing other work on main thread");
        
    }

    public static void longTask() {
        long t= System.currentTimeMillis();
        long end = t+3000;

        while(true) {
            
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                System.out.println("Done sleeping");
            }
            
            // if (System.currentTimeMillis() == end) {
            //     System.out.println("Finished long task");
            //     break;
            // } else if (Thread.currentThread().isInterrupted()) {
            //     System.out.println("This task has been interrupted prematurely");
            //     break;
            // }
        }
    }

}
