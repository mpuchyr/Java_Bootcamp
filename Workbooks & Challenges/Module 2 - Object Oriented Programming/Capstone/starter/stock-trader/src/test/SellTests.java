package src.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Before;
import org.junit.Test;

import src.main.model.account.Account;
import src.main.model.account.Personal;
import src.main.model.account.TFSA;

public class SellTests {
    
    Account[] accounts;

    @Before
    public void setup() {
        accounts = new Account[2];
        accounts[0] = new Personal(100.00);
        accounts[1] = new TFSA(100.00);

        accounts[0].addShares("Google", 10);
        accounts[1].addShares("Google", 10);
    }

    @Test
    public void personalSharesDecreaseAfterSale() {
        accounts[0].sell("Google", 3, 15);
        assertEquals(7, accounts[0].getShares("Google"));
    }

    @Test
    public void personalSharesDontDecreaseIfNotEnoughShares() {
        accounts[0].sell("Google", 100, 2000);
        assertEquals(10, accounts[0].getShares("Google"));
    }

    @Test
    public void personalFundsDontIncreaseIfNotEnoughShares() {
        accounts[0].sell("Google", 50, 100);
        assertEquals(100, accounts[0].getFunds());
    }

    @Test
    public void personalFundsIncreaseAfterSale() {
        accounts[0].sell("Google", 2, 10);
        assertEquals(109.50, accounts[0].getFunds());
    }

    @Test 
    public void TFSASharesDecreaseAfterSale() {
        accounts[1].sell("Google", 3, 15);
        assertEquals(7, accounts[1].getShares("Google"));
    }

    @Test
    public void TFSASharesDontDecreaseIfNotEnoughShares() {
        accounts[1].sell("Google", 50, 100);
        assertEquals(10, accounts[1].getShares("Google"));
    }

    @Test
    public void TFSAFundsIncreaseAfterSale() {
        accounts[1].sell("Google", 2, 10);
        assertEquals(109.90, accounts[1].getFunds());
    }

    @Test
    public void TFSAFundsDontIncreaseIfNotEnoughShares() {
        accounts[0].sell("Google", 50, 100);
        assertEquals(100, accounts[0].getFunds());
    }



}
