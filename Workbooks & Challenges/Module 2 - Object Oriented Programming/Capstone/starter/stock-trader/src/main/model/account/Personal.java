package src.main.model.account;

public class Personal extends Account {
    
    private static final double SALE_FEE = 0.05;

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

    @Override
    public boolean sell(String name, int amount, double price) {
        if (amount <= this.getShares(name)) {
            this.removeShares(name, amount);
            double totalPrice = this.getFunds() + price - (price * SALE_FEE);
            this.setFunds(totalPrice);
            return true;
        }      
        return false;
    }
}
