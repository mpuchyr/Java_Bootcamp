import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.InputMismatchException;
import java.util.Scanner;

import models.*;

public class Main {
    static Store store = new Store();
    static Cart cart = new Cart();

    public static void main(String[] args) {
        try {
            loadItems("products.txt");
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } finally {
            manageItems();

        }
        
    }



     public static void manageItems() {
        Scanner scan = new Scanner(System.in);
        while(true) {
            System.out.println("\n\t******************************JAVA GROCERS******************************\n");
            System.out.println(store);

            System.out.println("Options: \n\ta) Add to cart\n\tb) Remove from cart \n\tc) Checkout");
            String choice = scan.nextLine();
            if (choice.equalsIgnoreCase("a")) {
                System.out.print("\nChoose an aisle number between: 1 - 7 ");
                int row = scan.hasNextInt() ? scan.nextInt() - 1 : 404;
                scan.nextLine();
                System.out.print("\nChoose and item number between: 1 - 3 ");
                int column = scan.hasNextInt() ? scan.nextInt() - 1 : 404;
                if (row < 0 || row > 6 || column < 0 || column > 2) {
                    System.out.println("Invalid Option. Please choose again.");
                } else {
                    Item item = store.getItem(row, column);
                    boolean addedItem = cart.add(item);
                    if (addedItem) {
                        System.out.println(item.getName() + " was added to your shopping cart.");
                    } else {
                        System.out.println(item.getName() + " is already in your shopping cart.");
                    }
                    System.out.println("\n\nSHOPPING CART\n\n" + cart);          
                }
                scan.nextLine();
            } else if (choice.equalsIgnoreCase("b")) {
                System.out.print("Enter the item you'd like to remove: ");
                String name = scan.nextLine();
                if (!cart.isEmpty()) {
                    cart.remove(name);
                } else {
                    System.out.println("Your cart is empty");
                }
                System.out.println("\n\nSHOPPING CART\n\n" + cart);
            } else if (choice.equalsIgnoreCase("c")) {
                if (!cart.isEmpty()) {
                    System.out.println(cart.checkout());
                    break;
                } else {
                    System.out.println("Your cart is empty");
                }
            } else {
                break;
            }
        }
        scan.close();
     }
 

     public static void loadItems (String filename) throws FileNotFoundException {
         FileInputStream fis = new FileInputStream(filename);
         Scanner scan = new Scanner(fis);
         int row = 0;
         while(scan.hasNextLine()) {
            String[] line = scan.nextLine().split(";");
            for (int i = 0; i < line.length; i++) {
                String name = line[i].split("=")[0];
                double price = Double.parseDouble(line[i].split("=")[1]);
                Item item = new Item(name, price);
                store.setItem(row, i, item);
             }
            row++;
         }
         
         scan.close();
     }

}
