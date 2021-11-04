import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

import models.*;

public class Main {
    static Store store = new Store();
    public static void main(String[] args) {
        System.out.println("\n********************JAVA VIDEO STORE********************\n");

        // Movie movie = new Movie("The Shawshank Redemption", "Blue-Ray", 9.2);
        // Movie movie2 = new Movie("The Godfather", "Blue-Ray", 9.1);
        // Movie movie3 = new Movie("The Godfather: Part II", "DVD", 9.0);

        // Store store = new Store();
        // store.addMovie(movie);
        // store.addMovie(movie2);
        // store.addMovie(movie3);

        // System.out.println(store);

        try {
            loadMovies();
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } finally {
            System.out.println("MOVIES LOADED\n\n");
            System.out.println(store);
        }

        manageMovies();

        
        


    }

    /**
     * Name: manageMovies
     * Inside the function:
     *   • 1. Starts a new instance of Scanner;
     *   • 2. In an infinite loop, the user can choose to a) purchase b) rent c) return d) exit.
     *   •        case a: ask for the name and sell.
     *   •        case b: ask for the name and rent.
     *   •        case c: ask for the name and return.
     *   • 3. call close() from the Scanner object.
     */

    public static void manageMovies() {
        Scanner scan = new Scanner(System.in);
        while(true) {
            System.out.println("\nWould you like to ");
            System.out.println("\ta) purchase\n\tb) rent \n\tc) return");
            String choice = scan.nextLine();
            if (choice.equalsIgnoreCase("a")) {
                System.out.println("Enter the name of the movie: ");
                String name = scan.nextLine();
                if (name == null || name.isBlank()) {
                    System.out.println("\n\n The input you provided is not valid. Please try again\n");
                    continue;
                }
                if (store.getMovie(name) == null || !store.getMovie(name).isAvailable()) {
                    System.out.println("\n\n\n\nThat movie is not avaiable for purchase. Please try again\n");
                    continue;
                }
                store.action(name, "sell");
            } else if (choice.equalsIgnoreCase("b")) {
                System.out.println("Enter the name of the movie: ");
                String name = scan.nextLine();
                if (name == null || name.isBlank()) {
                    System.out.println("\n\nThe input you provided is not valid. Please try again\n");
                    continue;
                }
                store.action(name, "rent");
            } else if (choice.equalsIgnoreCase("c")) {
                System.out.println("Enter the name of the movie: ");
                String name = scan.nextLine();
                if (name == null || name.isBlank()) {
                    System.out.println("\n\n The input you provided is not valid. Please try again\n");
                    continue;
                }
                store.action(name, "return");
            } else {
                break;
            }

            System.out.println("\n\nUPDATED MOVIES");
            System.out.println(store);
        }
        scan.close();
    }


     public static void loadMovies() throws FileNotFoundException {
        FileInputStream fis = new FileInputStream("movies.txt");
        Scanner scan = new Scanner(fis);
        while(scan.hasNextLine()) {
            String[] arr = scan.nextLine().split("--");
            double rating = Double.parseDouble(arr[arr.length - 1]);
            Movie movie = new Movie(arr[0], arr[1], rating);
            store.addMovie(movie);
        
        }
        scan.close();
     }

}
