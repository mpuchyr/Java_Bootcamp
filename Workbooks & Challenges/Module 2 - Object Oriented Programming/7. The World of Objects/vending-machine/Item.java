public class Item {
    private String name;
    private double price;
    private int quantity;

    public Item(String name, double price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public Item(Item sourceItem) {
        this.name = sourceItem.getName();
        this.price = sourceItem.getPrice();
        this.quantity = sourceItem.getQuantity();
    }

    public String getName() {
        return this.name;
    }

    public double getPrice() {
        return this.price;
    }

    public int getQuantity() {
        return this.quantity;
    }

    public void setName(String newName) {
        this.name = newName;
    }

    public void setPrice(double newPrice) {
        this.price = newPrice;
    }

    public void setQuantity(int newQuantity) {
        this.quantity = newQuantity;
    }

    public String toString() {
        return this.name + ": " + this.price + " (" + this.quantity + ")";
    }
}
