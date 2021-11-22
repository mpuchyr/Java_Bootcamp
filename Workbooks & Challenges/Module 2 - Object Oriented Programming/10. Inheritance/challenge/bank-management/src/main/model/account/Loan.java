package src.main.model.account;

public class Loan extends Account {

    public Loan (String id, String name, double balance) {
        super(id, name, balance);
    }

    public Loan (Loan source) {
        super(source.getId(), source.getName(), source.getBalance());
    }

    @Override
    public void deposit(double amount) {
        double newBalance = this.round(this.getBalance() - amount);
        this.setBalance(newBalance);
    }

    @Override
    public boolean withdrawal(double amount) {
        double newBalance = this.round(this.getBalance() + amount + (amount * 0.02));
        if (newBalance > 10000) {
            return false;
        }
        this.setBalance(newBalance);
        return true;
    }

    @Override
    public Account clone() {
        return new Loan(this);
    }



}
