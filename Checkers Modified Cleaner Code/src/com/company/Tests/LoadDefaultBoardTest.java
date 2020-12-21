import com.company.model.LoadDefaultBoard;
import org.junit.Test;

import static org.junit.Assert.*;

public class LoadDefaultBoardTest {

    @Test
    public void getPlayerA() {
        LoadDefaultBoard loadDefaultBoard = new LoadDefaultBoard();
        assertEquals(12,loadDefaultBoard.getPlayerA().size());
    }

    @Test
    public void getPlayerB() {
        LoadDefaultBoard loadDefaultBoard = new LoadDefaultBoard();
        assertEquals(12,loadDefaultBoard.getPlayerB().size());
    }
}