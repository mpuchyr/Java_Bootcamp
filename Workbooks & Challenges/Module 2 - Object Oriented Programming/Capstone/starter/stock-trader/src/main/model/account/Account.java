package src.main.model.account;

import java.text.DecimalFormat;
import java.util.HashMap;

import src.main.utils.Color;

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

    public boolean removeShares(String name, int amount) {
        if (this.portfolio.get(name) != null) {
            int newAmount = this.portfolio.get(name) - amount;
            this.portfolio.replace(name, newAmount);
            return true;
        }
        return false;
    }

    public abstract boolean buy(String name, int amount, double price);

    public abstract boolean sell(String name, int amount, double price);

    public double round(double amount) {
        DecimalFormat formatter = new DecimalFormat("#.##");
        return Double.parseDouble(formatter.format(amount));
    }

    public String displayPortfolio() {
        String temp = "";
        for (String key: portfolio.keySet()) {
            temp += "\n  " + key.toString() + "\t" + portfolio.get(key) + "\n";
        }
        return temp;
    }

    public String toString() {
        return "\n  Stock\t\t"  + Color.RESET + "Shares" +
        "\n\n" + displayPortfolio() + Color.RESET +
        "\n  Funds Left\t" + Color.GREEN + "$" + round(this.getFunds()) + Color.RESET;
    }

}
