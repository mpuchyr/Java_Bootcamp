package src.main.model.account;

public class Savings extends Account {

    public Savings(int id, String name, double balance) {
        super(id, name, balance);
    }

    public Savings(Savings source) {
        super(source.getId(), source.getName(), source.getBalance());
    }

    @Override
    public void withdrawal(double amount) {

    }


}
