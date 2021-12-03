import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;


public class Main {

    static final String SALES = "data/sales.csv"; //Use backslash Windows users

    public static void main(String[] args) {
        
        try {
            Path path = Paths.get(Thread.currentThread().getContextClassLoader().getResource(SALES).toURI());
            Thread thread2 = new Thread(() -> {
                average(path, "Furniture");
                average(path, "Technology");
                average(path, "Office Supplies");
                totalAverage(path);
            });
            thread2.start();


            Scanner scan = new Scanner(System.in);
            System.out.print("Please enter your name to access the Global Superstore dataset: ");
            String name = scan.nextLine();
            System.out.println("Access Denied. We apologize for the inconvenience. Have a good day " + name + ".");
            scan.close();
        } catch (URISyntaxException e) {
            System.out.println(e.getMessage());
        }
    }


    public static Double average(Path path, String category) {
        
        try {
            return Files.lines(path)
            .skip(0)
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
            .skip(0)
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
