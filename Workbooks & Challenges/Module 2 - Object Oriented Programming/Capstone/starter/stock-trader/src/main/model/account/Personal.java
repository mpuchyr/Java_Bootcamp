package src.main.model.account;

public class Personal extends Account {
    
    public Personal(double funds) {
        super(funds);
    }

    public Personal(Personal source) {
        super(source);
    }
}
