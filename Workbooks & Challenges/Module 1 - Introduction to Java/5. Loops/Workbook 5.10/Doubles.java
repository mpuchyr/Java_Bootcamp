public class Doubles {
    public static void main(String[] args) {


        int dice1 = rollDice();
        int dice2 = rollDice();

        System.out.println("Dice 1: " + dice1);
        System.out.println("Dice 2: " + dice2);



         while (dice1 != dice2) {
             dice1 = rollDice();
             dice2 = rollDice();
             System.out.println("\nDice 1: " + dice1);
             System.out.println("Dice 2: " + dice2);
         }


        System.out.println("You rolled doubles!");
    }


    /** Task 1 
     * Function name: rollDice – rolls a dice between 1 and 6
     * @return randomNumber (int)
     * 
     */

     public static int rollDice () {
         int num = (int)(Math.random() * 6) + 1;
         return num;
     }

}





