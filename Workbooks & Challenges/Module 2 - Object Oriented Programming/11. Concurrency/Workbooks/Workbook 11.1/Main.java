import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;


public class Main {

    static final String SALES = "data/sales.csv"; //Use backslash Windows users
    static double furnitureAverage;
    static double technologyAverage;
    static double officeSuppliesAverage;
    static double total;

    public static void main(String[] args) {
        
        try {
            Path path = Paths.get(Thread.currentThread().getContextClassLoader().getResource(SALES).toURI());
            Thread thread2 = new Thread(() -> furnitureAverage = average(path, "Furniture"));
            Thread thread3 = new Thread(() -> technologyAverage = average(path, "Technology"));
            Thread thread4 = new Thread(() -> officeSuppliesAverage = average(path, "Office Supplies"));
            Thread thread5 = new Thread(() -> total = totalAverage(path));

            thread2.start();
            thread3.start();
            thread4.start();
            thread5.start();



            Scanner scan = new Scanner(System.in);
            System.out.print("Please enter your name to access the Global Superstore dataset: ");
            String name = scan.nextLine();
            try {
                thread2.join();
                thread3.join();
                thread4.join();
                thread5.join();

                System.out.println("\nThank you " + name + ". The average sales for Global Superstore are:\n");
                System.out.println("Average Furniture Sales: " + furnitureAverage);
                System.out.println("Average Technology Sales: " + technologyAverage);
                System.out.println("Average Office Supplies Sales: " + officeSuppliesAverage);
                System.out.println("Total Average: " + total);
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }

            scan.close();
        } catch (URISyntaxException e) {
            System.out.println(e.getMessage());
        }
    }


    public static Double average(Path path, String category) {
        
        try {
            return Files.lines(path)
            .skip(1)
            .map((line) -> line.toString().split(","))
            .filter((line) -> line[0].equals(category))
            .mapToDouble((line) -> Double.parseDouble(line[1]) * Double.parseDouble(line[2]))
            .average()
            .getAsDouble();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return 0.0;
        }

    }



     public static Double totalAverage(Path path){
        try {
            return Files.lines(path)
            .skip(1)
            .map((line) -> line.toString().split(","))
            .mapToDouble((line) -> Double.parseDouble(line[1]) * Double.parseDouble(line[2]))
            .average()
            .getAsDouble();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return 0.0;
        }

     }
  

}
