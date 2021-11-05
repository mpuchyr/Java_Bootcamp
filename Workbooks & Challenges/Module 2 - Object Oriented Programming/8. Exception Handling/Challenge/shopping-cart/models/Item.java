package models;

public class Item {
    private String name;
    private double price;

    public Item (String name, double price) throws IllegalArgumentException {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Name cannot be blank/null");
        }
        
        if (price < 0) {
            throw new IllegalArgumentException("Price cannot be less than 0");
        }

        this.name = name;
        this.price = price;
    }

    public Item (Item source) {
        this.name = source.name;
        this.price = source.price;
    }

    public String getName() {
        return this.name;
    }

    public double getPrice() {
        return this.price;
    }

    public void setName(String name) throws IllegalArgumentException {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Name cannot be blank/null");
        }
        this.name = name;
    }

    public void setPrice(double price) throws IllegalArgumentException {
        if (price < 0) {
            throw new IllegalArgumentException("Price cannot be less than 0");
        }
        this.price = price;
    }

    public String toString() {
        return this.name + ": $" + this.price + " ";
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }

        if (!(obj instanceof Item)) {
            return false;
        }

        Item  item = (Item)obj;
        return item.getName().equals(this.name) && item.getPrice() == this.price;
    }
  
}
