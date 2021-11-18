package src.main.model.account;

public class Loan extends Account {

    public Loan (int id, String name, double balance) {
        super(id, name, balance);
    }

    public Loan (Loan source) {
        super(source.getId(), source.getName(), source.getBalance());
    }

    @Override
    public void withdrawal(double amount) {

    }

}
