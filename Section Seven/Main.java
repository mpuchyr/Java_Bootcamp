import javax.management.loading.PrivateClassLoader;

public class Main {
    public static void main(String[] args) {
        Car nissan = new Car("Nissan", 5000, 2020, "red");


        Car dodge = new Car("Dodge", 8500, 2019, "blue");

        Car nissan2 = new Car(nissan);

        nissan2.setColor("yellow");

        nissan.drive();
        dodge.drive();
        nissan2.drive();
    }
}
