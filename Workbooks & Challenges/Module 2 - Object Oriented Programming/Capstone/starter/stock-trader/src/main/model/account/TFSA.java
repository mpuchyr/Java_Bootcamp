package src.main.model.account;

public class TFSA extends Account {
    
    public TFSA(double funds) {
        super(funds);
    }

    public TFSA(TFSA source) {
        super(source);
    }

    @Override
    public boolean buy(String name, int amount, double price) {
        double total = price + (price * 0.01);
        if (this.getFunds() >= (total)) {
            this.addShares(name, amount);
            this.setFunds(this.getFunds() - total);
            return true;
        }
        return false;
    }
}
