public class HighScore {
    public static void main(String[] args) {
        

        int[] scores = {randomNumber(), randomNumber(), randomNumber(), randomNumber(), randomNumber(), randomNumber(), randomNumber(), randomNumber(), randomNumber(), randomNumber()};
        for (int i = 0; i < scores.length; i++) {
            System.out.print(scores[i] + " ");
        }
        
        int highScore = 0;

        for (int i = 0; i < scores.length; i++) {
            if (scores[i] > highScore) {
                highScore = scores[i];
            }
        }

        System.out.println("\n\nThe highest score is: " + highScore + ". Give that man a cookie!");

    }

     public static int randomNumber() {
         int num = (int)(Math.random() * 50001);
         return num;
     }
    

}
