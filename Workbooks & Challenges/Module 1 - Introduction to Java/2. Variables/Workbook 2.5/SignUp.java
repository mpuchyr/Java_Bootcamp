import java.util.Scanner;

public class SignUp {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("Welcome to JavaGram! Let's sign you up.");
        
        System.out.println("\nWhat is your first name?");
        String firstName = scan.nextLine();

        System.out.println("\nWhat is your last name?");
        String lastName = scan.nextLine();

        System.out.println("\nHow old are you?");
        int age = scan.nextInt();

        System.out.println("\nPlease create a username.");
        scan.nextLine();
        String username = scan.nextLine();

        System.out.println("\nWhat city do you live in?");
        String city = scan.nextLine();

        System.out.println("\nWhat country do you live in?");
        String country = scan.nextLine();


        System.out.println("Thank you for joining JavaGram!");


        System.out.println("\nYour information:");
        System.out.println("\tFirst Name: " + firstName);
        System.out.println("\tLast Name: " + lastName);
        System.out.println("\tAge: " + age);
        System.out.println("\tUsername: " + username);
        System.out.println("\tCity: " + city);
        System.out.println("\tCountry: " + country);

        scan.close();

    }
}