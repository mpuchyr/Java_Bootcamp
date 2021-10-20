import java.util.Scanner;

public class Blackjack {

    public static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("\nWelcome to Java Casino!");
        System.out.println("Do you have a knack for Black Jack?");
        System.out.println("We shall see..");
        System.out.println("..Ready? Press anything to begin!");
        scan.nextLine();

        System.out.println("\n You get a \n");
        int card1 = drawRandomCard();
        int card2 = drawRandomCard();

        System.out.println(cardString(card1));
        System.out.println(cardString(card2));

        int playerTotal = (Math.min(card1, 10)) + (Math.min(card2, 10));
        System.out.println("Your total is: " + playerTotal); 

        int dealerCard1 = drawRandomCard();
        int dealerCard2 = drawRandomCard();

        System.out.println("The dealer shows \n" + cardString(dealerCard1) + 
            "\nand has a card facing down \n" + faceDown());
        System.out.println("\nThe dealer's total is hidden");
        


        String userAnswer = "";
        while (true) {
            userAnswer = hitOrStay();
            if (userAnswer.equals("stay")) {
                break;
            }
            int newCard = drawRandomCard();
            System.out.println(cardString(newCard));
            playerTotal += Math.min(newCard, 10);

            if (playerTotal > 21) {
                System.out.println("Bust! Player loses.");
                System.exit(0);
            }
            System.out.println("Your total is " + playerTotal);

        }

        System.out.println("Dealer's turn");
        System.out.println("The dealer's cards are \n");
        System.out.println(cardString(dealerCard1));
        System.out.println("\n and a \n");
        System.out.println(cardString(dealerCard2));

        int dealerTotal = Math.min(dealerCard1, 10) + Math.min(dealerCard2, 10);

        while (dealerTotal < 17) {
            int newCard = drawRandomCard();
            dealerTotal += Math.min(newCard, 10);
            System.out.println("Dealer gets a \n");
            System.out.println(cardString(newCard));
            System.out.println("\nDealer's total is " + dealerTotal);
            if (dealerTotal > 21) {
                System.out.println("Bust! Dealer loses");
                System.exit(0);
            }
        }

        if (playerTotal > dealerTotal) {
            System.out.println("Player wins!");
        } else {
            System.out.println("Dealer wins!");
        }

        
         scan.close();

    }


     public static int drawRandomCard () {
        int num = (int)(Math.random() * 13) + 1;
        return num;
     }

     public static String cardString (int cardNum) {
        switch (cardNum) {
            case 1:
                return  "   _____\n"+
                        "  |A _  |\n"+ 
                        "  | ( ) |\n"+
                        "  |(_'_)|\n"+
                        "  |  |  |\n"+
                        "  |____V|\n";
            case 2:
                return  "   _____\n"+              
                        "  |2    |\n"+ 
                        "  |  o  |\n"+
                        "  |     |\n"+
                        "  |  o  |\n"+
                        "  |____Z|\n";
            case 3:
                return  "   _____\n" +
                        "  |3    |\n"+
                        "  | o o |\n"+
                        "  |     |\n"+
                        "  |  o  |\n"+
                        "  |____E|\n";
            case 4:
                return  "   _____\n" +
                        "  |4    |\n"+
                        "  | o o |\n"+
                        "  |     |\n"+
                        "  | o o |\n"+
                        "  |____h|\n";
            case 5:
                return  "   _____ \n" +
                        "  |5    |\n" +
                        "  | o o |\n" +
                        "  |  o  |\n" +
                        "  | o o |\n" +
                        "  |____S|\n";
            case 6:
                return  "   _____ \n" +
                        "  |6    |\n" +
                        "  | o o |\n" +
                        "  | o o |\n" +
                        "  | o o |\n" +
                        "  |____6|\n";
            case 7:
                return  "   _____ \n" +
                        "  |7    |\n" +
                        "  | o o |\n" +
                        "  |o o o|\n" +
                        "  | o o |\n" +
                        "  |____7|\n";
            case 8:
                return  "   _____ \n" +
                        "  |8    |\n" +
                        "  |o o o|\n" +
                        "  | o o |\n" +
                        "  |o o o|\n" +
                        "  |____8|\n";
            case 9:
                return  "   _____ \n" +
                        "  |9    |\n" +
                        "  |o o o|\n" +
                        "  |o o o|\n" +
                        "  |o o o|\n" +
                        "  |____9|\n";
            case 10:
                return  "   _____ \n" +
                        "  |10  o|\n" +
                        "  |o o o|\n" +
                        "  |o o o|\n" +
                        "  |o o o|\n" +
                        "  |___10|\n";
            case 11:
                return  "   _____\n" +
                        "  |J  ww|\n"+ 
                        "  | o {)|\n"+ 
                        "  |o o% |\n"+ 
                        "  | | % |\n"+ 
                        "  |__%%[|\n";
            case 12:
                return  "   _____\n" +
                        "  |Q  ww|\n"+ 
                        "  | o {(|\n"+ 
                        "  |o o%%|\n"+ 
                        "  | |%%%|\n"+ 
                        "  |_%%%O|\n";
            case 13:
                return  "   _____\n" +
                        "  |K  WW|\n"+ 
                        "  | o {)|\n"+ 
                        "  |o o%%|\n"+ 
                        "  | |%%%|\n"+ 
                        "  |_%%%>|\n";
            default:
                return "error";
        }
     }


    public static String faceDown() {
        return
        "   _____\n"+
        "  |     |\n"+ 
        "  |  J  |\n"+
        "  | JJJ |\n"+
        "  |  J  |\n"+
        "  |_____|\n";
    }
    

     public static String hitOrStay() {
        System.out.println("Would you like to hit or stay?");
        String userAnswer = scan.nextLine();
        while (true) {
            if (userAnswer.equals("hit") || userAnswer.equals("stay")) {
                break;
            }
            System.out.println("Please write 'hit' or 'stay'");
            userAnswer = scan.nextLine();

        }
        return userAnswer;
     }
    }

