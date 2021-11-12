package src.main;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import src.main.models.Game;
import src.main.models.Team;

public class Main {

    static Game game;
    static final String TEAMS_FILE = "src/main/teams.txt";
    static final String PLAYS_FILE = "src/main/plays.txt";


    public static void main(String[] args) {

        String [][] data;
        try {
            data = getData();
            game = new Game(
                new Team(data[0][0], data[0][1], data[0][2], new String[] {data[0][3], data[0][4], data[0][5]}),
                new Team(data[1][0], data[1][1], data[1][2], new String[] {data[1][3], data[1][4], data[1][5]})
            );
            startGame();
            printResult();
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
        
        
    }


    /**
     * Function name: getData
     * @return (String[][])
     * @throws FileNotFoundException
     * 
     * Inside the function:
     *   1. Returns data from TEAMS_FILE as a String[][] array
     */

     public static String[][] getData() throws FileNotFoundException {
        FileInputStream fis = new FileInputStream(TEAMS_FILE);
        Scanner scan = new Scanner(fis);
        String [][] data = new String[2][6];
        int lineCount = 0;
        while (scan.hasNextLine()) {
           String[] line = scan.nextLine().split(",");
           for (int i = 0; i < line.length; i++) {
            System.out.println(line[i]);
            data[lineCount][i] = line[i];
           }
           lineCount++;
            
        }
        scan.close();
        return data;
     }


    /** Function name: startGame
     * 
     * Inside the function:
     *    1. Grabs each play from plays.txt and calls game.simulate(play);
     *    2. Prints the return from game.simulate(play)
     *        - println("\n" + <return> + "\n");
     */

     public static void startGame() throws FileNotFoundException{
         FileInputStream fis = new FileInputStream(PLAYS_FILE);
         Scanner scan = new Scanner(fis);
         while(scan.hasNextLine()) {
             String play = scan.nextLine();
             String result = game.simulate(play);
             System.out.println("\n" + result + "\n");
             wait(3);
         }
         scan.close();
     }


    /** Function name: printResult()
     * 
     * Inside the function:
     *    1. Prints the final score: println("\nGRYFFINDOR: " + <gryffindor score> + " SLYTHERIN: " + <slytherin score>);
     *    2. Prints the winner: println("\n" + <winner team name> + " WINS!");
     *  
     */

    public static void printResult() {
        Team[] teams = game.getTeams();
        System.out.println("\n" + teams[0].getHouse() + ": " + game.getScore(teams[0]) + " " +
            teams[1].getHouse() + ": " + game.getScore(teams[1]));
        String winner = game.getScore(teams[0]) > game.getScore(teams[1]) ? teams[0].getHouse() : teams[1].getHouse();
        System.out.println("\n" + winner + " WINS!");
        
    }

    /**
     * Function name: wait
     * @param sec
     * 
     * Inside the function:
     *  1. Make the code sleep for X seconds.
     */

     public static void wait (int sec) {
        try {
            TimeUnit.SECONDS.sleep(sec);
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        } 
        
     }


  }
