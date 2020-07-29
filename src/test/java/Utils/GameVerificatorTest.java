package Utils;

import Exceptions.VerificationException;
import Model.Board;
import org.junit.jupiter.api.Assertions;

import static org.junit.jupiter.api.Assertions.*;

class GameVerificatorTest {

    @org.junit.jupiter.api.Test
    void isWinningDisc() {
        Board board = new Board(8,8,4);
        int rowIndex = 7;
        int colIndex = 0;
        board.setPlayerDisc(rowIndex,colIndex,1);
        Assertions.assertFalse(GameVerificator.isWinningDisc(board,rowIndex,colIndex));
        board.setPlayerDisc(6,colIndex,1);
        board.setPlayerDisc(5,colIndex,1);
        board.setPlayerDisc(7,1,2);
        board.setPlayerDisc(6,1,2);
        board.setPlayerDisc(5,1,2);
        colIndex = 2;
        board.setPlayerDisc(rowIndex,colIndex,1);
        assertFalse(GameVerificator.isWinningDisc(board,rowIndex,colIndex));
        colIndex = 0;
        rowIndex = 4;
        board.setPlayerDisc(rowIndex,colIndex,1);
        assertTrue(GameVerificator.isWinningDisc(board,rowIndex,colIndex));

    }

    @org.junit.jupiter.api.Test
    void isColumnFull() {
        Board board = new Board(8,8,4);
        int rowIndex = 7;
        int colIndex = 0;
        assertFalse(GameVerificator.isColumnFull(board, colIndex));
        board.setPlayerDisc(rowIndex,colIndex,1);
        assertFalse(GameVerificator.isColumnFull(board, colIndex));
        rowIndex--;
        board.setPlayerDisc(rowIndex,colIndex,1);
        rowIndex--;
        board.setPlayerDisc(rowIndex,colIndex,1);
        rowIndex--;
        board.setPlayerDisc(rowIndex,colIndex,1);
        rowIndex--;
        board.setPlayerDisc(rowIndex,colIndex,1);
        rowIndex--;
        board.setPlayerDisc(rowIndex,colIndex,1);
        rowIndex--;
        board.setPlayerDisc(rowIndex,colIndex,1);
        rowIndex--;
        board.setPlayerDisc(rowIndex,colIndex,1);
        assertTrue(GameVerificator.isColumnFull(board, colIndex));

    }

    @org.junit.jupiter.api.Test
    void firstEmptyRow() {
        Board board = new Board(8,8,4);
        int rowIndex = 7;
        int colIndex = 0;
        assertEquals(rowIndex, GameVerificator.firstEmptyRow(board, colIndex));
        board.setPlayerDisc(rowIndex,colIndex,1);
        assertEquals(rowIndex-1, GameVerificator.firstEmptyRow(board, colIndex));
    }

    @org.junit.jupiter.api.Test
    void verifyColumn() throws Exception{
        try {
            Board board = new Board(8, 8, 4);
            assertEquals(true, GameVerificator.verifyColumn(board, 7));
            GameVerificator.verifyColumn(board, 8);
        }catch (VerificationException e) {
            assertEquals(e.getMessage(), GameProperties.getPropertyValue("101"));
        }
    }
}