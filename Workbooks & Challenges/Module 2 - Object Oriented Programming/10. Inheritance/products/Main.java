import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.Scanner;

import models.Pants;
import models.Product;
import models.Shirt;

public class Main {
  
    static final String FILE_NAME = "products.txt";

    public static void main(String[] args) {
        
        try {
            Product[] products = getData();
            Arrays.sort(products);
            for (int i = 0; i < products.length; i++) {
                System.out.println(products[i]);
            }
        } catch (FileNotFoundException e){
            System.out.println(e.getMessage());
        } catch (NoSuchElementException e) {
            System.out.println(e.getMessage());
        }
       
    }

    public static void printArray(Product[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);   
        }
    }

    
  
    /**
     * Function Name: getData
     * @return Product[]
     * @throws FileNotFoundException
     * 
     * Inside the function:
     *   1. Loads the data from products.txt
     */

     public static Product[] getData() throws FileNotFoundException {
         FileInputStream fis = new FileInputStream(FILE_NAME);
         Scanner scan = new Scanner(fis);

         Product[] products = new Product[18];

         for (int i = 0; scan.hasNext(); i++) {             
            switch (scan.next()) {
                 case "PANTS": products[i] = new Pants(scan.nextInt(), scan.nextDouble(), scan.next(), scan.next()); break;
                 case "SHIRT": products[i] = new Shirt(Shirt.Size.valueOf(scan.next()), scan.nextDouble(), scan.next(), scan.next()); break;
             }
         }

         scan.close();
         return products;
     }
}
