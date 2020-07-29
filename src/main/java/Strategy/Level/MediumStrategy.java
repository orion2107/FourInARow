package Strategy.Level;

import Model.Board;
import Utils.GameVerificator;

public class MediumStrategy implements LevelStrategy {

    public int chooseMove(Board board, int playerId) {
        int emptyrow= 0;
        // first check if a move can win
        for (int i=0; i<board.getColumnSize(); i++) {
            if (!GameVerificator.isColumnFull(board,i)) {
                emptyrow = GameVerificator.firstEmptyRow(board,i);
                board.setPlayerDisc(emptyrow, i, playerId);
                if (GameVerificator.isWinningDisc(board, emptyrow, i)) {
                    board.clearChoice(emptyrow, i);// reset
                    return i;
                }
                board.clearChoice(emptyrow, i);// reset
            }
        }
        // otherwise then pick up any move that will prevent other player to win
        // in case there is a win on next turn
        int counter = 0; // i count other player possible winnings
        int chosenrow = 0;
        for (int i=0; i<board.getColumnSize(); i++) {
            if (!GameVerificator.isColumnFull(board,i)) {
                emptyrow = GameVerificator.firstEmptyRow(board,i);
                board.setPlayerDisc(emptyrow, i, playerId-1); // assume the other player does this
                if (GameVerificator.isWinningDisc(board, emptyrow, i)) {
                    board.clearChoice(emptyrow, i); // reset
                    counter++; // we found a winning disc
                    chosenrow = i; // remember the row
                }
                board.clearChoice(emptyrow, i); // reset
            }
        }
        // we block the player if there is exactly one winning disc
        if (counter == 1) return chosenrow;

        // else if other player wins no matter what, pick up first non full column
        for (int i=0; i<board.getColumnSize(); i++)
            if (!GameVerificator.isColumnFull(board,i)){
                return i;
            }
        return -1;
    }
}
