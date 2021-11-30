package src.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Before;
import org.junit.Test;

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

    @Test
    public void personalBuyTest() {
        accounts[0].buy("Google", 1, 40.00);
        assertEquals(1, accounts[0].getShares("Google"));
    }

    @Test
    public void personalInsufficientFundsTest() {
        accounts[0].buy("Google", 1, 150.00);
        assertEquals(0, accounts[0].getShares("Google"));
    }

    @Test
    public void personalFundsDecrease() {
        accounts[0].buy("Google", 1, 10.00);
        assertEquals(90.00, accounts[0].getFunds());
    }

    @Test
    public void TFSABuyTest() {
        accounts[1].buy("Google", 1, 10.00);
        assertEquals(1, accounts[1].getShares("Google"));
    }

    @Test
    public void TFSAInsuffientFunds() {
        accounts[1].buy("Google", 1, 150.00);
        assertEquals(0, accounts[1].getShares("Google"));
    }

    @Test
    public void TFSAFundsDecrease(){
        accounts[1].buy("Google", 1, 10.00);
        assertEquals(89.90, accounts[1].getFunds());
    }

}
