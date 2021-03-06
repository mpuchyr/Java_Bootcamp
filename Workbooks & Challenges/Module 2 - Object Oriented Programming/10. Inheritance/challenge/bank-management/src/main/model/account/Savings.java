package src.main.model.account;

public class Savings extends Account {

    public Savings(String id, String name, double balance) {
        super(id, name, balance);
    }

    public Savings(Savings source) {
        super(source.getId(), source.getName(), source.getBalance());
    }

    @Override
    public void deposit(double amount) {
        double newBalance = this.round(this.getBalance() + amount);
        this.setBalance(newBalance);
    }

    @Override
    public boolean withdrawal(double amount) {
        double newBalance = this.round(this.getBalance() - amount - 5.00);
        if (newBalance >= 0) {
            this.setBalance(newBalance);
            return true;
        }
        return false;
    }

    @Override
    public Account clone() {
        return new Savings(this);
    }


}
