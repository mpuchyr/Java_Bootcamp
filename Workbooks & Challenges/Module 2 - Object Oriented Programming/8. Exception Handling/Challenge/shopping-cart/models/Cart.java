package models;

import java.util.ArrayList;

public class Cart {

    ArrayList<Item> items;

    public Cart() {
        this.items = new ArrayList<Item>();
    }

    public Item getItem(int index) {
        return items.get(index);
    }

    public void setItem(int index, Item item) {
        items.set(index, new Item(item));
    }

    public boolean add (Item item) {
        if (!items.contains(item)) {
            items.add(item);
            return true;
        }
        
        return false;
    }

    public boolean isEmpty() {
        return this.items.isEmpty();
    }

    public void remove(String name) throws IllegalStateException {
        if (this.items.isEmpty()) {
            throw new IllegalStateException("Cart is empty");
        }
        
        for (int i = 0; i < items.size(); i++) {
            if (items.get(i).getName().equals(name)) {
                items.remove(i);
                break;
            }
        }
    }


    public String checkout() throws IllegalStateException {
        if (this.items.isEmpty()) {
            throw new IllegalStateException("Cart is empty");
        }
        double subtotal = 0;
        for (int i = 0; i < this.items.size(); i++) {
            subtotal += this.items.get(i).getPrice();
        }
        double tax = subtotal * 0.13;
        double total = tax + subtotal;
        return "\tRECEIPT\n\n"
            + "\tSubtotal: $" + subtotal + "\n"
            + "\tTax: $" + tax + "\n" 
            + "\tTotal: $" + total + "\n";
    }

    public String toString() {
        String temp = "";
        for (int i = 0; i < items.size(); i++) {
            temp += items.get(i) + "\n";
        }
        
        return temp;
    }
    
}
