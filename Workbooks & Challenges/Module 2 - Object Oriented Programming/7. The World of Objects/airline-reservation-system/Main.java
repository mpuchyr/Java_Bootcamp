import java.util.Arrays;

public class Main {
  
    public static void main(String[] args) {

        Person person = new Person("Rayan Slim", "Canadian", "01/01/1111", 5);

        person.chooseSeat();



        System.out.println("Name: " + person.getName() + "\n" + "Nationality: " + person.getNationality() + "\n" + "Date of Birth: " 
            + person.getDateOfBirth() + "\n" + "Seat Number: " + person.getSeatNumber() + "\n");

        boolean qualified = person.applyPassport();

        if (qualified) {
            System.out.println("Congratulations " + person.getName() + ". Your passport was approved!");
        } else {
            System.out.println("We're sorry " + person.getName() + ". We cannot process your application.");
        }

        // System.out.println("Name: " + person2.getName() + "\n" + "Nationality: " + person2.getNationality() + "\n" + "Date of Birth: " 
        //     + person2.getDateOfBirth() + "\n" + "Seat Number: " + person2.getSeatNumber() + "\n");
    }
  
  
}
