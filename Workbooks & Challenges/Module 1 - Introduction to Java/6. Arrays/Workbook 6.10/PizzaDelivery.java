import java.util.Scanner;

public class PizzaDelivery {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        /**  Task 1: 
         *   1. Ask the user: How many pizza toppings do you want?. 
         *   2. Then, pick up the result using Scanner.
         */
        System.out.println("How many pizza toppings do you want?");
        int numOfToppings = scan.nextInt();

        String[] toppings = new String[numOfToppings];

        scan.nextLine();
        System.out.println("Great, enter each topping!");
        for (int i = 0; i < toppings.length; i++) {
            System.out.print(i + ". ");
            toppings[i] = scan.nextLine();
        }

        System.out.println("");
        for (int i = 0; i < toppings.length; i++) {
            System.out.println(i + ". " + toppings[i]);
        }

        
        System.out.println("\nPress anything to confirm your order.");
        scan.nextLine();
        System.out.println("Great, a driver is on the way!");


        scan.close();


         
    }
}
