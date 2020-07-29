package Model;

import Model.Player.ComputerPlayer;
import Strategy.Level.EasyStrategy;
import Strategy.Level.LevelStrategy;
import Strategy.Level.MediumStrategy;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ComputerPlayerTest {

    @Test
    void getEasyMove() {
        ComputerPlayer player = new ComputerPlayer(1,"John Doe");
        LevelStrategy strategy = new EasyStrategy();
        Board board = new Board(8,8,4);
        player.setLevelStrategy(strategy);
        int move = player.getMove(board);
        Assertions.assertTrue( move< board.getColumnSize() && move >= 0);
    }

    @Test
    void getMediumMove(){
        ComputerPlayer player = new ComputerPlayer(1,"John Doe");
        LevelStrategy strategy = new MediumStrategy();
        Board board = new Board(8,8,4);
        for(int i=7 ; i > 4; i--)
            board.setPlayerDisc(i,0,1);
        player.setLevelStrategy(strategy);
        int move = player.getMove(board);
        Assertions.assertEquals(0,move);
    }
}