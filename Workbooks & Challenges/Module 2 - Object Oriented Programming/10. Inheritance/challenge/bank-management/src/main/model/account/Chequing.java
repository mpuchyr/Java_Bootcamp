package src.main.model.account;

public class Chequing extends Account { 

    public Chequing(int id, String name, double balance) {
        super(id, name, balance);
    }

    public Chequing(Chequing source) {
        super(source.getId(), source.getName(), source.getBalance());
    }

    @Override
    public void withdrawal(double amount) {
        if (amount > this.getBalance() && (this.getBalance() - amount > -200)) {
            this.setBalance(this.getBalance() - amount - 5.50);
        } else if (amount > this.getBalance() && (this.getBalance() - amount <= -200)) {
            this.setBalance(-200.00);
        } else {
            this.setBalance(this.getBalance() - amount);
        }
    }

}
