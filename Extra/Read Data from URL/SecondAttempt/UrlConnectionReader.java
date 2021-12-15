import java.net.*;
import java.util.Scanner;
import java.io.*;

public class UrlConnectionReader {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("What url would you like to get the contents for? ");
        String url = scan.nextLine();

        String output = getUrlContents(url);
        System.out.println(output);

        scan.close();
        // String output = getUrlContents("https://javatpoint.com/java-tutorial");
        // System.out.println(output);
    }

    private static String getUrlContents(String theUrl) {
        StringBuilder content = new StringBuilder();
        try {
            URL url = new URL(theUrl);
            URLConnection urlConnection = url.openConnection();

            InputStreamReader inputStreamReader = new InputStreamReader(urlConnection.getInputStream());
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            String line;
            while((line = bufferedReader.readLine()) != null) {
                content.append(line + "\n");
            }
            bufferedReader.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return content.toString();
    }
}
