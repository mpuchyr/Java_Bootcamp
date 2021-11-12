import models.Pants;
import models.Product;
import models.Shirt;

public class Main {
  
    static final String FILE_NAME = "products.txt";

    public static void main(String[] args) {
        

        Shirt shirt = new Shirt("SMALL", 5.99, "blue", "JAVA VUITTON");
        Pants pants = new Pants(32, 24.99, "blue", "JAVA KLEIN");
        Shirt shirt2 = new Shirt(shirt);
        Pants pants2 = new Pants(pants);
 
        shirt.getPrice();
        pants.setPrice(59.99);

    }
  
    /**
     * Function Name: getData
     * @return Product[]
     * @throws FileNotFoundException
     * 
     * Inside the function:
     *   1. Loads the data from products.txt
     */
}
