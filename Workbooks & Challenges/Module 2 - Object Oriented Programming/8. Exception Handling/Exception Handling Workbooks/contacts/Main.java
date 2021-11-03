import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.util.Scanner;

import models.*;

public class Main {

    static ContactManager manager = new ContactManager();
    public static void main(String[] args) {
        
        
        String filename = "contacts.txt";
        try {
            loadContacts(filename);
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }

        manageContacts();

        
        
    }


    public static void manageContacts() {
        Scanner scan = new Scanner(System.in);
        while (true) {
            System.out.println("Would you like to ");
            System.out.println("\ta) add a contact");
            System.out.println("\tb) remove a contact");
            System.out.println("\tc) exit");
            String choice = scan.nextLine();
            if (choice.equalsIgnoreCase("a")) {
                
                System.out.print("\tName: ");
                String name = scan.nextLine();
                
                System.out.print("\tPhone Number: ");
                String phone = scan.nextLine();
                
                System.out.print("\tBirth Date: ");
                String birthDate = scan.nextLine();

                if (name.isBlank() || phone.isBlank() || birthDate.isBlank() || phone.length() < 5) {
                    System.out.println("\nThe input you provided is not valid. Registration failed");
                    continue;
                }

                try {
                    Contact contact = new Contact(name, phone, birthDate);
                    manager.addContact(contact);
                } catch (ParseException e){
                    System.out.println(e.getMessage());
                    continue;
                } finally {
                    System.out.println("\n\nUPDATED CONTACTS\n\n");
                    System.out.println(manager);
                }
            } else if (choice.equalsIgnoreCase("b")) {
                System.out.println("\nWho would you like to remove?");
                String name = scan.nextLine();
                try {
                    manager.removeContact(name);
                } catch (IllegalStateException e) {
                    System.out.println(e.getMessage());
                    continue;
                }
                
                System.out.println("\n\nUPDATED CONTACTS\n\n");
                System.out.println(manager);
            } else if (choice.equalsIgnoreCase("c")) {
                break;
            } else {
                System.out.println("You did not choose a valid option, please choose again.");
            }

        }
        scan.close();
    }

    public static void loadContacts(String filename) throws FileNotFoundException {
        FileInputStream file = new FileInputStream(filename);
        Scanner scan = new Scanner(file);
        while (scan.hasNext()) {
            String name = scan.next();
            String phoneNumber = scan.next();
            String birthDate = scan.next();
            try {
                Contact contact = new Contact(name, phoneNumber, birthDate);
                manager.addContact(contact);
            } catch (ParseException e) {
                System.out.println(e.getMessage());
            } finally {
                System.out.println("CONTACTS LOADED\n\n");
                System.out.println(manager);
            }

        }
        scan.close();
    }

}
