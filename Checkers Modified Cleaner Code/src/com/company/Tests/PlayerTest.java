import com.company.model.LoadDefaultBoard;
import com.company.model.Player;
import com.company.model.PlayerA;
import org.junit.Test;

import static org.junit.Assert.*;

public class PlayerTest {

    @Test
    public void reduceCheckers() {
        LoadDefaultBoard loadDefaultBoard = new LoadDefaultBoard();
        PlayerA playerA = new PlayerA(12,loadDefaultBoard.getPlayerA(),true);
        playerA.reduceCheckers();
        assertEquals(11,playerA.getCheckersLeft());
    }
}