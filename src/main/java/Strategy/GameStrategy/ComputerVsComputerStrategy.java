package Strategy.GameStrategy;

import Controller.GameManager;
import Events.EventsEnum;
import Events.EventsHandler;
import Model.GameState;
import Utils.GameVerificator;

import static java.lang.Thread.*;

public class ComputerVsComputerStrategy implements GameStrategy {

    public void setPlayerMove(GameState gameState, int colIndex) {
        int rowIndex = GameVerificator.firstEmptyRow(gameState.getBoard(), colIndex);
        gameState.getBoard().setPlayerDisc(rowIndex, colIndex, gameState.getCurrentPlayer());
        if (GameVerificator.isWinningDisc(gameState.getBoard(), rowIndex, colIndex)) {
            gameState.setWinner(true);
        }else {
            gameState.setNextPlayerTurn();
        }
//        gameState.notifyStateChanged();
        EventsHandler.getInstance().notifyEvent(gameState.getGameId(), EventsEnum.PLAYER_MOVED);

        try {
            colIndex = gameState.getPlayer(gameState.getCurrentPlayer()).getMove(gameState.getBoard());
            GameManager.getInstance().setPlayerMove(gameState.getGameId(), colIndex);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
