public class WeatherNetwork {
    public static void main(String[] args) {

        int temp = 5;  

        String forecast = "";

        if (temp >= -15 && temp <= -1) {
            System.out.println("The forecast is FREEZING! Stay home!");
        } else if (temp >= 0 && temp <= 10) {
            System.out.println("The forecast is Chilly. Wear a coat!");
        } else {
            System.out.println("It's warm. Go outside!");
        }

        System.out.println(forecast);
    }
}
