package src.main.model.account;

import java.util.HashMap;

public abstract class Account {

    private HashMap<String, Integer> portfolio;
    private double funds;

    public Account(double funds) {
        portfolio = new HashMap<String, Integer>();
        this.funds = funds;
    }

    public Account(Account source) {
        this.portfolio = source.portfolio;
        this.funds = source.funds;
    }

    
    public double getFunds() {
        return this.funds;
    }

    public void setFunds(double amount) {
        this.funds = amount;
    }

    // Buying and Retrieving Shares

    public int getShares(String name) {
        if (this.portfolio.get(name) != null) {
            return this.portfolio.get(name);
        }
        return 0;
    }

    public void addShares(String name, int amount) {
        if (this.portfolio.get(name) != null) {
            int newAmount = this.portfolio.get(name) + amount;
            this.portfolio.replace(name, newAmount);
        } else {
            this.portfolio.put(name, amount);
        }
    }

    public abstract boolean buy(String name, int amount, double price);


}
