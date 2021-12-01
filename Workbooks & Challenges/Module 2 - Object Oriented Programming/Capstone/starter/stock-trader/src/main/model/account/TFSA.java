package src.main.model.account;

public class TFSA extends Account {
    
    private static double TRADE_FEE = 0.01;

    public TFSA(double funds) {
        super(funds);
    }

    public TFSA(TFSA source) {
        super(source);
    }

    @Override
    public boolean buy(String name, int amount, double price) {
        double total = price + (price * TRADE_FEE);
        if (this.getFunds() >= (total)) {
            this.addShares(name, amount);
            this.setFunds(this.getFunds() - total);
            return true;
        }
        return false;
    }

    @Override
    public boolean sell(String name, int amount, double price) {
        if (amount <= this.getShares(name)) {
            this.removeShares(name, amount);
            double totalPrice = this.getFunds() + price - (price * TRADE_FEE);
            this.setFunds(totalPrice);
            return true;
        }      
        return false;
    }
}
