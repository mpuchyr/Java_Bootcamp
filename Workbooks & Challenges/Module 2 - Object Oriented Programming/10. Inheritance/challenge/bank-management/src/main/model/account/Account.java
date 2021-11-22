package src.main.model.account;

import java.text.DecimalFormat;

public abstract class Account {
    private String id;
    private String name;
    private double balance;
    public enum TransactionType {
        DEPOSIT, WITHDRAW
    }

    public Account (String id, String name, double balance) {
        if (id == null || id.isBlank()) {
            throw new IllegalArgumentException("Id cannot be null/blank");
        }
        if (name == null || id.isBlank()) {
            throw new IllegalArgumentException("Name cannot be null/blank");
        }

        this.id = id;
        this.name = name;
        this.balance = balance;
    }

    public Account (Account source) {
        this.id = source.id;
        this.name = source.name;
        this.balance = source.balance;
    }

    // Getters
    public String getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public double getBalance() {
        return this.balance;
    }

    // Setters
    public void setId(String id) {
        if (id == null || id.isBlank()) {
            throw new IllegalArgumentException("Id cannot be null/blank");
        }
        this.id = id;
    }

    public void setName(String name) {
        if (name == null || id.isBlank()) {
            throw new IllegalArgumentException("Name cannot be null/blank");
        }
        this.name = name;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    // Deposit
    public abstract void deposit(double amount);

    // Withdrawal
    public abstract boolean withdrawal(double amount);

    // Round
    protected double round(double amount) {
        DecimalFormat formatter = new DecimalFormat("#.##");
        return Double.parseDouble(formatter.format(amount));
    }

    //To String
    public String toString() {
        return this.getClass().getSimpleName() + "    "
            + "\tName: " + this.getName() + ""
            + "\tId: " + this.getId() + ""
            + "\tBalance: $" + this.getBalance() + "";
    }

    public abstract Account clone();


}
