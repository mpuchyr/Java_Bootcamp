import java.util.Scanner;

public class CounterTool {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("I hear you like to count by threes\n");
        System.out.println("Jimmy: It depends.");
        System.out.println("Oh, ok...");

        System.out.print("\n1. Pick a number to count by: ");
        int num1 = scan.nextInt();

        System.out.print("2. Pick a number to start counting from: ");
        int num2 = scan.nextInt();

        System.out.print("3. Pick a number to count to: ");
        int num3 = scan.nextInt();

        for (int i = num2; i <= num3; i += num1) {
          System.out.print(i + " ");
        }

        scan.close();
    }
}
