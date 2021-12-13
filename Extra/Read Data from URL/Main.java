import java.net.*;
import java.io.*;

public class Main {

    public static void main(String[] args) {
        
        try {
            URL oracle = new URL("http://www.oracle.com");
            BufferedReader in = new BufferedReader(
                new InputStreamReader(oracle.openStream())
            );
    
            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                System.out.println(inputLine);
            }
            in.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }


    }

}


