import java.util.Scanner;

public class Main {

    static final double TARGET = 0.5;
    static final double PRECISION = 0.000000001; 
    static double result = 0;
    public static void main(String[] args) {

        Runnable runnable = () -> result = generateNumber();
        Thread thread2 = new Thread(runnable);
        thread2.start();
        double precision = difference(result);
        
        Scanner scan = new Scanner(System.in);
        System.out.println("Please enter a name to generate a number: ");
        scan.nextLine();
        try {
            thread2.join();
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("The computer returned a value of: " + result);
        System.out.println("The value was generated to a precision of : " + precision);

        scan.close();
    }

     public static double generateNumber() {
         double number = Math.random();
         double difference = difference(number);
         while (difference > PRECISION) {
             number = Math.random();
            difference = difference(number);
         }

         return difference;
     }

     public static double difference(double number) {
        return Math.abs(TARGET - number);
     }


}
