package src.main.model;

public class Trade {
    public enum Type {
        MARKET_BUY, MARKET_SELL
    }
    
    private Stock stock;
    private Type type;
    private int amount;
    private double price;

    public Trade(Stock stock, Type type, int amount, double price) {
        this.stock = stock;
        this.type = type;
        this.amount = amount;
        this.price = price;
    }

    public Trade(Trade source) {
        this.stock = source.stock;
        this.type = source.type;
        this.amount = source.amount;
        this.price = source.price;
    }

    public Stock getStock() {
        return this.stock;
    }

    public Type getType() {
        return this.type;
    }

    public int getAmount() {
        return this.amount;
    }

    public double getPrice() {
        return this.price;
    }

    public void setStock(Stock stock) {
        this.stock = stock;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
