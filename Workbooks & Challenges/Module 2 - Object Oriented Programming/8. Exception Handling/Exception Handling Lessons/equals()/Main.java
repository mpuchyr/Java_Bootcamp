import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Car car = new Car("Toyota", "blue");
        Car sameCar = new Car("Honda", "blue");
        Scanner scan = new Scanner(System.in);
        System.out.println(car.equals(sameCar));
        scan.close();
    }

}
