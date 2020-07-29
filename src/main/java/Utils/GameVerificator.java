package Utils;

import Exceptions.VerificationException;
import Model.Board;

public class GameVerificator {

    // is the disc at board[rowIndex][colIndex] winning?
    public static boolean isWinningDisc(Board board, int rowIndex, int colIndex){
        int currentChoice = board.getDiscAtBoard(rowIndex, colIndex);
        int count = 1;

        // horizontal right
        for (int i=colIndex+1; i < board.getColumnSize(); i++) {
            if (board.getDiscAtBoard(rowIndex, i) == currentChoice)
                count++;
            else break;
        }
        if (count >= board.getNumberOfWinningDiscs()) return true; // won horizontally
        // keep counting horizontal left
        for (int i=colIndex-1; i >=0; i--) {
            if (board.getDiscAtBoard(rowIndex, i) == currentChoice)
                count++;
            else break;
        }
        if (count >= board.getNumberOfWinningDiscs()) return true; // won horizontally

        count = 1;
        // vertical down
        for (int i=rowIndex+1; i < board.getRowSize(); i++) {
            if (board.getDiscAtBoard(i, colIndex) == currentChoice)
                count++;
            else break;
        }
        if (count >= board.getNumberOfWinningDiscs()) return true; // won vertical
        // keep counting vertical up
        for (int i=rowIndex-1; i >=0; i--) {
            if (board.getDiscAtBoard(i, colIndex) == currentChoice)
                count++;
            else
                break;
        }
        if (count >= board.getNumberOfWinningDiscs()) return true; // won vertical

        // first diagonal:  /
        count = 1;
        // up
        int kol = colIndex+1;
        for (int i=rowIndex-1; i >= 0; i--) {
            if (kol >= board.getColumnSize()) break; // we reached the end of the board right side
            if (board.getDiscAtBoard(i, kol) == currentChoice)
                count++;
            else
                break;
            kol++;
        }
        if (count >= board.getNumberOfWinningDiscs()) return true;
        // keep counting down
        kol = colIndex-1;
        for (int i=rowIndex+1; i < board.getRowSize(); i++) {
            if (kol < 0) break; // we reached the end of the board left side
            if (board.getDiscAtBoard(i, kol) == currentChoice)
                count++;
            else
                break;
            kol--;
        }
        if (count >= board.getNumberOfWinningDiscs()) return true; // won diagonal "/"

        // second diagonal : \
        count = 1;
        // up
        kol = colIndex-1;
        for (int i=rowIndex-1; i >= 0; i--) {
            if (kol < 0) break; // we reached the end of the board left side
            if (board.getDiscAtBoard(i, kol) == currentChoice)
                count++;
            else
                break;
            kol--;
        }
        if (count >= board.getNumberOfWinningDiscs()) return true; // won diagonal "\"
        // keep counting down
        kol = colIndex+1;
        for (int i=rowIndex+1; i < board.getRowSize(); i++) {
            if (kol >= board.getColumnSize()) break; // we reached the end of the board right side
            if (board.getDiscAtBoard(i, kol) == currentChoice)
                count++;
            else
                break;
            kol++;
        }
        if (count >= board.getNumberOfWinningDiscs()) return true; // won diagonal "\"

        return false;
    }

    public static boolean isColumnFull(Board board, int colIndex){
        for (int i = 0; i < board.getRowSize(); i++) {
            if (board.isEmptyCell(i, colIndex))
                return false;
        }
        return true;
    }

    // returns the ROW index of the first empty cell in the COLUMN rowIndex. -1 if all full
    public static int firstEmptyRow(Board board, int colIndex) {
        for (int i = board.getRowSize()-1; i >=0; i--) {
            if (board.isEmptyCell(i, colIndex)) return i;
        }
        return -1;
    }

    public static Boolean verifyColumn(Board board, int colIndex) throws VerificationException {
        if (colIndex < 0 || colIndex > board.getColumnSize()-1){
            throw new VerificationException(GameProperties.getPropertyValue("101"));
        }else if (isColumnFull(board, colIndex)) {
            throw new VerificationException(GameProperties.getPropertyValue("102"));
        }
        return true;
    }

}
