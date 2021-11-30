package src.main.model.account;

public class Personal extends Account {
    
    public Personal(double funds) {
        super(funds);
    }

    public Personal(Personal source) {
        super(source);
    }

    @Override
    public boolean buy(String name, int amount, double price) {
        if (price <= this.getFunds()) {
            double newFunds = this.getFunds() - price;
            this.setFunds(newFunds);
            this.addShares(name, amount);
            return true;
        }
        return false;
    }
}
