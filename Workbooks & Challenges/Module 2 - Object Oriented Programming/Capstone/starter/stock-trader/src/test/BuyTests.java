package src.test;

import org.junit.Before;

import src.main.model.account.Account;
import src.main.model.account.Personal;
import src.main.model.account.TFSA;

public class BuyTests {
    
    Account[] accounts;

    @Before
    public void setup() {
        accounts = new Account[2];
        accounts[0] = new Personal(100.00);
        accounts[1] = new TFSA(100.00);
    }

    

}
