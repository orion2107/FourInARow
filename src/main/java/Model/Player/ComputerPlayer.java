package Model.Player;

import Model.Board;
import Strategy.Level.LevelStrategy;
import Strategy.Level.MediumStrategy;

public class ComputerPlayer extends AbstractPlayer {

    LevelStrategy levelStrategy;
    public ComputerPlayer(int id, String name) {
        super(id, name);
        this.levelStrategy = new MediumStrategy();
    }

    @Override
    public boolean isComputer() {
        return true;
    }

    public LevelStrategy getLevelStrategy() {
        return levelStrategy;
    }

    public void setLevelStrategy(LevelStrategy levelStrategy) {
        this.levelStrategy = levelStrategy;
    }

    @Override
    public int getMove(Board board) {
        return levelStrategy.chooseMove(board, getId());
    }

}
