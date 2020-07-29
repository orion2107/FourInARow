package Model;

import Model.Mode.GameLevel;
import Model.Mode.GameMode;
import Model.Player.AbstractPlayer;
import Observer.Observer;
import Utils.Constants;

import java.util.*;

public class GameState {
    private GameLevel gameLevel = GameLevel.Easy;
    private Board board = null;
    private Map<Integer, AbstractPlayer> players = null;
    private int currentPlayer = 1;
    private boolean hasWinner = false;
    private Long gameId;
    private GameMode gameMode;
    private List<Observer> observers = new ArrayList<Observer>();

    public GameState(Long gameId, GameMode gameMode/*, ProxyViewer proxyViewer*/) {
        this.gameId = gameId;
        this.gameMode = gameMode;
        players = new HashMap<Integer, AbstractPlayer>();
    }

    public GameLevel getGameLevel() {
        return gameLevel;
    }

    public void setGameLevel(GameLevel gameLevel) {
        this.gameLevel = gameLevel;
    }

    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public Collection<AbstractPlayer> getPlayers() {
        return players.values();
    }

    public void addPlayer(AbstractPlayer player) {
        this.players.put(player.getId(), player);
    }

    public int getCurrentPlayer() {
        return currentPlayer;
    }

    public void setCurrentPlayer(int currentPlayer) {
        this.currentPlayer = currentPlayer;
    }

    public Boolean getWinner() {
        return hasWinner;
    }

    public void setWinner(Boolean hasWinner) {
        this.hasWinner = hasWinner;
    }

    public Long getGameId() {
        return gameId;
    }

    public void setGameId(Long gameId) {
        this.gameId = gameId;
    }

    public GameMode getGameMode() {
        return gameMode;
    }

    public AbstractPlayer getPlayer(Integer playerId) {
        return this.players.get(playerId);
    }

    public void setGameMode(GameMode gameMode) {
        this.gameMode = gameMode;
    }

    public void setNextPlayerTurn() {
        if (this.currentPlayer == Constants.FIRST_PLAYER_ID){
            this.currentPlayer = Constants.SECOND_PLAYER_ID;
        }else {
            this.currentPlayer = Constants.FIRST_PLAYER_ID;
        }
    }

    public void notifyStateChanged() {
        for(Observer observer: observers) {
            observer.update();
        }
    }

    public void attach(Observer observer) {
        observers.add(observer);
    }
}
