import java.util.Scanner;

public class RockPaperScissors {
    public static void main(String[] args) {
        
        Scanner scan = new Scanner(System.in);

        System.out.println("Let's play Rock Paper Scissors.");
        System.out.println("When I say 'shoot', Choose: rock, paper, or scissors.\n");
        System.out.println("Are you ready? Write 'yes' if you are.");

        String response = scan.nextLine();

        if (response.equals("yes")) {
            System.out.println("Great!");
            System.out.println("rock - paper - scissors, shoot!");
            String choice = scan.nextLine();
            String compChoice = computerChoice();
            String result = result(choice, compChoice);
            printResult(choice, compChoice, result);

        } else {
            System.out.println("Darn, some other time...");
        }
              

        scan.close();
    }


    public static String computerChoice() {
        int choice = (int)(Math.random() * 3);
        switch (choice) {
            case 0:
                return "rock";
            case 1:
                return "paper";
            case 2:
                return "scissors";
            default:
                return "error";
        }
    }


    public static String result(String yourChoice, String computerChoice) {
        String result = "";
        boolean winCondition1 = yourChoice.equals("rock") && computerChoice.equals("scissors");
        boolean winCondition2 = yourChoice.equals("paper") && computerChoice.equals("rock");
        boolean winCondition3 = yourChoice.equals("scissors") && computerChoice.equals("paper");

        boolean loseCondition1 = computerChoice.equals("rock") && yourChoice.equals("scissors");
        boolean loseCondition2 = computerChoice.equals("paper") && yourChoice.equals("rock");
        boolean loseCondition3 = computerChoice.equals("scissors") && yourChoice.equals("paper");

        if (winCondition1 || winCondition2 || winCondition3) {
            result = "You win";
        } else if (loseCondition1 || loseCondition2 || loseCondition3) {
            result = "You lose";
        } else {
            result = "It's a tie";
        }

        return result;
      }
 

     public static void printResult(String yourChoice, String computerChoice, String result) {
        System.out.println("You chose:          " + yourChoice);
        System.out.println("The computer chose: " + computerChoice);
        System.out.println(result);
     }

}
