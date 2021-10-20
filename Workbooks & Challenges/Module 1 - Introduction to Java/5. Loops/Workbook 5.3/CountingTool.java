import java.util.Scanner;

public class CountingTool {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("Hi Timmy! Choose a number to count to: ");
        int choice = scan.nextInt();

        for (int i = 0; i <= choice; i++) {
            System.out.print(i + " ");
        }

        scan.close();
    }
}
