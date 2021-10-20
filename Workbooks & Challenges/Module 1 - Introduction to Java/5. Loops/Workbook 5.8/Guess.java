import java.util.Scanner;

public class Guess  {
    public static void main(String[] args) {

        int secretNum = (int)(Math.random() * 5) + 1;

       System.out.print("I chose a number between 1 and 5. Try to guess it: ");
        
       Scanner scan = new Scanner(System.in);

       int guess = scan.nextInt();

       while (guess != secretNum) {
            System.out.print("Guess gain: ");
            guess = scan.nextInt();
       }

       System.out.println("You got it!");
       scan.close();
    }

}
