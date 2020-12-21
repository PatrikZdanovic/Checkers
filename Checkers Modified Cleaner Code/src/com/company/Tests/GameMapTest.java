import com.company.model.Checkers;
import com.company.model.GameMap;
import com.company.model.PlayerA;
import com.company.model.PlayerB;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class GameMapTest {

    @Test
    public void isHittableRight() {
        ArrayList<Checkers> testCheckers = new ArrayList<>();
        ArrayList<Checkers> testCheckersEnemy = new ArrayList<>();
        testCheckers.add(new Checkers(1,2,1));
        testCheckersEnemy.add(new Checkers(2,3,-1));
        GameMap gameMap = new GameMap();
        gameMap.updateMap(testCheckers,testCheckersEnemy);
        gameMap.draw(true);
        assertTrue(gameMap.isHittableRight(2,3,true));
    }

    @Test
    public void isAvailable() {
        GameMap gameMap = new GameMap();
        assertTrue(gameMap.isAvailable(5,5));
    }
}