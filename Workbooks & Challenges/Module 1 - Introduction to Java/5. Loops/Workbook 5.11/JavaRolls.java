import java.util.Scanner;

public class JavaRolls {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
      

        System.out.println("Le'ts play Rolling Java. Type anything to start.");
        String entry = scan.nextLine();

        System.out.println("Great, here are the rules:\n");
        System.out.println("• If you roll a 6, the game stops.");
        System.out.println("• If you roll a 4, nothing happens.");
        System.out.println("• Otherwise, you get 1 point.\n");
        System.out.println("You must collect at least 3 points to win. Enter anything to roll: ");
        

       int score = 0;
      
       while (true) {
        entry = scan.nextLine();
        int diceRoll = rollDice();
        System.out.println("You rolled a " + diceRoll);

        if (diceRoll == 6) {
          System.out.println("End of game.");
          break;
        } else if (diceRoll == 4) {
          System.out.println("Zero points. Keep rolling.");
        } else {
          score += 1;
          System.out.println("One point. Keep rolling.");
        }
       }

      System.out.println("\nYou score is: " + score);
      if (score >= 3) {
        System.out.println("Wow, that's lucky. You win!");
      } else {
        System.out.println("Tough luck, you lose :(");
      }

    }
  

     public static int rollDice() {
       int num = (int)(Math.random() * 6) + 1;
       return num;
     }
  
}
