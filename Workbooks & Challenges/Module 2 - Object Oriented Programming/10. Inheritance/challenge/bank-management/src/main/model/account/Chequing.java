package src.main.model.account;

import src.main.model.account.impl.Taxable;

public class Chequing extends Account implements Taxable { 

    public Chequing(String id, String name, double balance) {
        super(id, name, balance);
    }

    public Chequing(Chequing source) {
        super(source.getId(), source.getName(), source.getBalance());
    }

    @Override
    public void deposit(double amount) {
        double newBalance = this.round(this.getBalance() + amount);
        this.setBalance(newBalance);
    }

    @Override
    public boolean withdrawal(double amount) {
        double newBalance = this.round(this.getBalance() - amount);
        if (newBalance < 0) {
            newBalance -= 5.50;
        }
        if (newBalance <= -200) {
            return false;
        }
        this.setBalance(newBalance);
        return true;
    }

}
