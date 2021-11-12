package src.test;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Before;
import org.junit.Test;

import src.main.models.Game;
import src.main.models.Team;


public class GameTest {

    Game game;
    Team home;
    Team away;

    @Before
    public void setup() {
        home = new Team("GRYFFINDOR", "Oliver", "Harry", 
        new String[] {"Angelina", "Ginny", "Katie"});
  
        away = new Team("SLYTHERIN", "Vincent",  "Draco", 
        new String[] {"Bridget", "Harper", "Malcolm"});

        game = new Game(home, away);
    }

    @Test
    public void getPlaceholderTest() {
        assertEquals("chaser", game.getPlaceholder("<chaser> gets the next pass"));
    }

    @Test
    public void replacePlaceholderTest() {
        assertEquals("Katie gets the next pass", game.replacePlaceholder("<chaser> gets the next pass", "chaser", "Katie"));
    }

    @Test
    public void quaffleScoreTest() {
        game.quaffleScore(home);
        game.quaffleScore(home);
        assertEquals(20, game.getScore(home));
    }

    @Test
    public void catchSnitchTest() {
        game.catchSnith(away);
        assertEquals(150, game.getScore(away));
    }





}
