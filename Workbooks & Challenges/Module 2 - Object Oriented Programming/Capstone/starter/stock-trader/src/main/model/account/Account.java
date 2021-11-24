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

    


}
