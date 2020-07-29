package Strategy.GameStrategy;

import Model.GameState;

public interface GameStrategy {
    public void setPlayerMove (GameState gameState, int colIndex);
}
