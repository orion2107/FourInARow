package Model;

import org.junit.Before;
import org.junit.ClassRule;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class BoardTest {

    @ClassRule
    final int row = 10;
    final int col =10;
    final int NumOfWinningDisks = 5;
    Board board = new Board(row,col,NumOfWinningDisks);

    @Test
    void getRowSize() {
        Assertions.assertEquals(row, board.getRowSize());
        Assertions.assertNotEquals(4, board.getRowSize());
    }

    @Test
    void getColumnSize() {
        Assertions.assertEquals(col, board.getColumnSize());
        Assertions.assertNotEquals(4, board.getColumnSize());
    }

    @Before
    public void setBoard(){
        for(int i=0; i<board.getRowSize();  i++)
            for(int j =0 ; j<board.getColumnSize(); j++)
                board.getGameBoard()[i][j] = 4;
    }
    @Test
    void resetBoard() {
        board.resetBoard();
        for(int i=0; i<board.getRowSize();  i++)
            for(int j =0 ; j<board.getColumnSize(); j++)
                Assertions.assertTrue(board.isEmptyCell(i, j));
    }

//    @Before
//    public void SetMove(){
//        for(int i=0; i<board.getRowSize();  i++)
//            for(int j =0 ; i<board.getColumnSize(); j++)
//                board.getGameBoard()[i][j] = 0;
//        board.setPlayerDisc(0,1,1);
//    }
//    @Test
//    void getRowAfterPlayerMove() {
//        Assertions.assertEquals(board.GetRowAfterPlayerMove(1),0);
//    }


    @Before
    public void setAlmostAllBoard(){
            for (int i = 0; i < board.getRowSize(); i++)
                for (int j = 0; i < board.getColumnSize() - 1; j++)
                    board.getGameBoard()[i][j] = 1;
    }
    @Test
    void boardIsNotFull() {
        Assertions.assertTrue(board.BoardIsNotFull());
    }

    @Before
    public void clearSell(){
        board.getGameBoard()[9][9] = 0;
    }

    @Test
    void isEmptyCell() {
        Assertions.assertTrue(board.isEmptyCell(9,9));
    }
}