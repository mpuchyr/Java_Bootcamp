package src.main.models;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class Cart {
    ArrayList<Item> items;

    public Cart() {
        this.items = new ArrayList<Item>();
    }

    public Item getItem(int index) {
        return new Item(this.items.get(index));
    }

    public void setItem(int index, Item item) {
        this.items.set(index, new Item(item));
    }

    public boolean add(Item item) {
        if (this.items.contains(item)) {
            return false;
        }        
        this.items.add(item);
        return true;
    }

    public void remove(String name) {
        if (this.items.isEmpty()) {
            throw new IllegalStateException("Cannot remove item from empty cart");
        }
        this.items.removeIf((item) -> item.getName().equals(name));
    }

    public void clear() {
        this.items.clear();
    }

    public boolean contains(Item item) {
       for (int i = 0; i < this.items.size(); i++) {
            if (items.get(i).equals(item)) {
                return true;
            }
       }

       return false;
    }

    public double getSubtotal() {
        return this.items.stream()
            .mapToDouble((item) -> item.getPrice())
            .sum();
    }

    public double getTax(double subTotal) {
        DecimalFormat formatter = new DecimalFormat("#.##");
        return Double.parseDouble(formatter.format(subTotal * 0.13));
    }

    public double getTotal(double subTotal, double tax) {
        
        return subTotal + tax;
    }

    public String checkout() {
        if (this.items.isEmpty()) {
            throw new IllegalStateException("Cannot checkout an empty cart");
        }
        return "\tRECEIPT\n\n" +
            "\tSubtotal: $" + getSubtotal() + "\n" +
            "\tTax: $" + getTax(getSubtotal()) + "\n" +
            "\tTotal: $" + getTotal(getSubtotal(), getTax(getSubtotal())) + "\n";
    }

    public String toString() {
        String temp = "";
        for (int i = 0; i < this.items.size(); i++) {
            temp += this.items.get(i).toString();
            temp += "\n";
        }
        return temp;
    }

}
