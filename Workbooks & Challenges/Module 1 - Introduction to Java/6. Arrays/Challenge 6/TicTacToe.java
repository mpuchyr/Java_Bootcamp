import java.util.Scanner;

public class TicTacToe {

    static Scanner scan = new Scanner(System.in);
    public static void main(String[] args) {
        
            System.out.println("\nLet's play tic tac toe");

            char[][] board = {
              {'_', '_', '_'},
              {'_', '_', '_'},
              {'_', '_', '_'}
            };

            printBoard(board);
            int score = 0;

            for (int i = 0; i < 9; i++) {
              System.out.print("Turn: ");
              if (i % 2 == 0) {
                System.out.print("X");
                int[] choice = askUser(board);
                board[choice[0]][choice[1]] = 'X';
                printBoard(board);
              } else {
                System.out.print("O");
                int[] choice = askUser(board);
                board[choice[0]][choice[1]] = 'O';
                printBoard(board);
                
              }

              if (i >= 4) {
                score = checkWin(board);
              }
                
              if (score == 3 || score == -3) {
                break;
              } 

              System.out.println();
            }

            if (score == 3) {
              System.out.println("X wins");
            } else if (score == -3) {
              System.out.println("O wins");
            } else {
              System.out.println("It's a tie!");
            }

            scan.close();
        }


    public static void printBoard(char[][] board) {
      for (int i = 0; i < board.length; i++ ) {
        System.out.println("");
        System.out.print("\t");
        for (int j = 0; j < board.length; j++) {
          System.out.print(board[i][j] + " ");
        }
        System.out.println("");
        
      }
    }      


     public static int[] askUser(char[][] board) {
       System.out.print("• pick a row and column number: ");

       while (true) {
        
        int row = scan.nextInt();
        int column = scan.nextInt();

        int[] choice = {row, column};

        if (board[row][column] == '_') {
          return choice;
        } else {
          System.out.print("Spot taken, try again: ");
        }

       }


       
     }


     public static int checkWin(char[][] board) {
       int count = 0;
       for (int i = 0; i < board.length; i++) {
         for (int j = 0; j < board[i].length; j++) {
           if (board[i][j] == 'X') {
             count += 1;
           } else if (board[i][j] == 'O') {
             count -= 1;
           }
         }
        if (count == 3 || count == -3) {
          return count;
        } else {
          count = 0;
        }
       }

       for (int i = 0; i < board.length; i++) {
         for (int j = 0; j < board.length; j++) {
           if (board[j][i] == 'X') {
             count += 1;
           } else if (board[j][i] == 'O') {
             count -= 1;
           }
         }
        if (count == 3 || count == -3) {
          return count;
        } else {
          count = 0;
        }
       }
       count = 0;

       for (int i = 0; i < board.length; i++) {
         if (board[i][i] == 'X') {
           count += 1;
         } else if (board[i][i] == 'O'){
           count -= 1;
         }
         if (count == 3 || count == -3) {
           return count;
         } 
       }
       count = 0;

       for (int i = 0; i < board.length; i++) {
         if (board[i][2 - i ] == 'X') {
           count += 1;
         } else if (board[i][2 - i] == 'O'){
           count -= 1;
         }
         if (count == 3 || count == -3) {
           return count;
         }
       }
       count = 0;

       return count;
     }


}
