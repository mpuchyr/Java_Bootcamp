public class RandomNumbers {
    public static void main(String[] args) {

        int[][] tDArray = new int[100][10];

        for (int i = 0; i < tDArray.length; i++) {
            for (int j = 0; j < tDArray[i].length; j++) {
                tDArray[i][j] = randomNumber();
            }
        }

        print2DArray(tDArray);

    }


     public static int randomNumber() {
         return (int)(Math.random() * 101);
     }



    public static void print2DArray(int[][] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }
    }
}
