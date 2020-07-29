package Strategy.GameStrategy;

import Controller.GameManager;
import Events.EventsEnum;
import Events.EventsHandler;
import Model.GameState;
import Utils.GameVerificator;

public class PlayerVsPlayerStrategy implements GameStrategy {

    public void setPlayerMove(GameState gameState, int colIndex) {
        int rowIndex = GameVerificator.firstEmptyRow(gameState.getBoard(), colIndex);
        gameState.getBoard().setPlayerDisc(rowIndex, colIndex, gameState.getCurrentPlayer());
        if (GameVerificator.isWinningDisc(gameState.getBoard(), rowIndex, colIndex)) {
            gameState.setWinner(true);
            EventsHandler.getInstance().notifyEvent(gameState.getGameId(), EventsEnum.WINNER);
            GameManager.getInstance().closeGame(gameState.getGameId());
        }else {
            gameState.setNextPlayerTurn();
            EventsHandler.getInstance().notifyEvent(gameState.getGameId(), EventsEnum.PLAYER_MOVED);
        }
//        gameState.notifyStateChanged();
    }
}
