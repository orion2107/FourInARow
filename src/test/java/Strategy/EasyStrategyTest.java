package Strategy;

import Model.Board;
import Strategy.Level.EasyStrategy;
import org.junit.Rule;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class EasyStrategyTest {

    @Rule
    Board board = new Board(1,1,5);
    EasyStrategy strategy = new EasyStrategy();
    @Test
    void chooseMove() {
        Assertions.assertEquals(0,strategy.chooseMove(board,1));
    }
}