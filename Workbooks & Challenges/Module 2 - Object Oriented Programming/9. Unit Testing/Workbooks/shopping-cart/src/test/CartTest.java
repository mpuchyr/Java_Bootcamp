package src.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.Before;
import org.junit.Test;

import src.main.models.Cart;
import src.main.models.Item;

public class CartTest {

    Cart cart;

    @Before
    public void setup() {
        cart = new Cart();
        cart.add(new Item("Pepsi", 1.99));
        cart.add(new Item("Crush", 1.99));
    }

    @Test
    public void itemAddedTest() {
        cart.add(new Item("Coke", 1.99));
        assertTrue(cart.contains(new Item("Coke", 1.99)));
    }

    @Test 
    public void skipsDuplicate() {
        assertFalse(cart.add(new Item("Pepsi", 1.99)));
    }

    @Test
    public void removedItemTest() {
        cart.remove("Pepsi");
        assertFalse(cart.contains(new Item("Pepsi", 1.99)));
    }

    @Test
    public void subtotalIsValid() {
        assertEquals(3.98, cart.getSubtotal());
    }

    @Test
    public void taxIsValid() {
        assertEquals(3.9, cart.getTax(30));
    }

    @Test
    public void totalIsValid() {
        assertEquals(113, cart.getTotal(100, 13));
    }

    @Test(expected = IllegalStateException.class)
    public void invalidRemoveState() {
        cart.clear();
        cart.remove("Pepsi");
    }

    @Test(expected = IllegalStateException.class)
    public void invalidCheckoutState() {
        cart.clear();
        cart.checkout();
    }
    
}
