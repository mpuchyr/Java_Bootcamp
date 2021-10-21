import java.util.Arrays;
import java.util.Scanner;

public class Hangman {

    public static String[] words = {"ant", "baboon", "badger", "bat", "bear", "beaver", "camel",
    "cat", "clam", "cobra", "cougar", "coyote", "crow", "deer",
    "dog", "donkey", "duck", "eagle", "ferret", "fox", "frog", "goat",
    "goose", "hawk", "lion", "lizard", "llama", "mole", "monkey", "moose",
    "mouse", "mule", "newt", "otter", "owl", "panda", "parrot", "pigeon", 
    "python", "rabbit", "ram", "rat", "raven","rhino", "salmon", "seal",
    "shark", "sheep", "skunk", "sloth", "snake", "spider", "stork", "swan",
    "tiger", "toad", "trout", "turkey", "turtle", "weasel", "whale", "wolf",
    "wombat", "zebra"};

    public static String[] gallows = {"+---+\n" +
    "|   |\n" +
    "    |\n" +
    "    |\n" +
    "    |\n" +
    "    |\n" +
    "=========\n",

    "+---+\n" +
    "|   |\n" +
    "O   |\n" +
    "    |\n" +
    "    |\n" +
    "    |\n" +
    "=========\n",

    "+---+\n" +
    "|   |\n" +
    "O   |\n" +
    "|   |\n" +
    "    |\n" +
    "    |\n" +
    "=========\n",

    " +---+\n" +
    " |   |\n" +
    " O   |\n" +
    "/|   |\n" +
    "     |\n" +
    "     |\n" +
    " =========\n",

    " +---+\n" +
    " |   |\n" +
    " O   |\n" +
    "/|\\  |\n" + //if you were wondering, the only way to print '\' is with a trailing escape character, which also happens to be '\'
    "     |\n" +
    "     |\n" +
    " =========\n",

    " +---+\n" +
    " |   |\n" +
    " O   |\n" +
    "/|\\  |\n" +
    "/    |\n" +
    "     |\n" +
    " =========\n",

    " +---+\n" +
    " |   |\n" +
    " O   |\n" +
    "/|\\  |\n" + 
    "/ \\  |\n" +
    "     |\n" +
    " =========\n"};

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        boolean playing = true;

        while (playing) {
            String word = chooseWord();
            char[] letters = word.toCharArray();
            char[] blanks = new char[letters.length];

            String endMessage = "RIP";
            

            for (int i = 0; i < blanks.length; i++) {
                blanks[i] = '_';
            }

            int mistakes = 0;
            int prevMistakes = 0;
            char[] misses = {' ', ' ', ' ', ' ', ' ', ' '};


            while (mistakes < 6) {
                showGallows(mistakes);
                System.out.print("Word: ");
                displayCharacters(blanks);

                System.out.println();
                System.out.print("Misses: ");
                displayCharacters(misses);
                System.out.println();

                System.out.print("Guess: " );
                String letter = scan.nextLine();
                System.out.println();

                prevMistakes = mistakes;
                mistakes += updateBlanksAndMistakes(blanks, letters, letter);
                if (mistakes > prevMistakes) {
                    updateMisses(misses, letter);
                }

                if (Arrays.equals(letters, blanks)) {
                    endMessage = "You Win!";
                    break;
                }
            }

            if (mistakes == 6) {
                System.out.println("The word was: '" + word + "'");
            }     
            System.out.println(endMessage);
            System.out.println();

            System.out.println("Would you like to play again?");
            System.out.println("Enter 'yes' to keep playing or anything else to exit");
            String choice = scan.nextLine();

            if (!choice.equals("yes")) {
                playing = false;
            }
        }
        
           

        scan.close();

    }


    public static String chooseWord() {
        String word = words[(int)(Math.random() * words.length)];
        return word;
    }

    public static void displayCharacters(char[] characters) {
        for (int i = 0; i < characters.length; i++) {
            System.out.print(characters[i] + " ");
        }
        System.out.println();
    }

    public static int updateBlanksAndMistakes(char[] blanks, char[] letters, String guess) {
        char letter = guess.charAt(0);
        int count = 0;
        for (int i = 0; i < blanks.length; i++) {
            if (letters [i] == letter) {
                blanks[i] = letter;
                count += 1;
            }
        }
        if (count > 0) {
            return 0;
        } else {
            return 1;
        }
    }

    public static void showGallows(int stageNum) {
        System.out.println(gallows[stageNum]);
    }

    public static void updateMisses (char[] misses, String guess) {
        char letter = guess.charAt(0);
        for (int i = 0; i < misses.length; i++) {
            if (misses[i] == ' ') {
                misses[i] = letter;
                break;
            }
        }
    }



}





