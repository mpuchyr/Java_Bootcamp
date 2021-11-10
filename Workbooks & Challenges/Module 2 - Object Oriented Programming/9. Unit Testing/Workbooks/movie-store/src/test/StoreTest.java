package src.test;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

import org.junit.Before;
import org.junit.Test;

import src.main.models.Store;
import src.main.models.Movie;

public class StoreTest {

    Store store;

    @Before
    public void setup() {
        store = new Store();
        store.addMovie(new Movie("The Shawshank Redemption", "Blue-Ray", 9.2));
        store.addMovie(new Movie("The Godfather", "Blue-Ray", 9.1));
    }

    @Test
    public void movieAdded() {
       assertTrue(store.contains(new Movie("The Godfather", "Blue-Ray", 9.1))); 
    }

    @Test
    public void sellMovieTest() {
        store.sellMovie(new Movie("The Godfather", "Blue-Ray", 9.1));
        assertFalse(store.contains(new Movie("The Godfather", "Blue-Ray", 9.1)));
    }

    @Test
    public void rentMovieTest() {
        store.rentMovie("The Shawshank Redemption");
        int movieIndex = store.getMovieIndex("The Shawshank Redemption");
        assertFalse(store.getMovie(movieIndex).isAvailable());
    }

    @Test
    public void returnMovieTest() {
        store.rentMovie("The Shawshank Redemption");
        store.returnMovie("The Shawshank Redemption");
        int movieIndex = store.getMovieIndex("The Shawshank Redemption");
        assertTrue(store.getMovie(movieIndex).isAvailable());
    }

    @Test(expected = IllegalStateException.class)
    public void movieNotInStock() {
        store.rentMovie("The Godfather");
        store.sellMovie(new Movie("The Godfather", "Blue-Ray", 9.1));
    }

}
