package Model.Player;

import Model.Board;

public class HumanPlayer extends AbstractPlayer {

    public HumanPlayer(int id, String name/*MoveStrategies strategy*/){

        super(id,name/*strategy*/);
    }

    @Override
    public boolean isComputer() {
        return false;
    }

    @Override
    public int getMove(Board board) {
        return 0;
    }

}
