package src.main.model.account;

public abstract class Account {
    private int id;
    private String name;
    private double balance;

    public Account (int id, String name, double balance) {
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
    public int getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public double getBalance() {
        return this.balance;
    }

    // Setters
    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    // Deposit
    public void deposit(double amount) {
        this.balance += amount;
    }

    // Withdrawal
    public abstract void withdrawal(double amount);
}
