package Controller;

public abstract class GameTemplate {
    abstract public void initialize();
    abstract public void startPlay();
    abstract public void endPlay();
    //template method
    public final void Play(){

        //initialize the game
        initialize();

        //start game
        startPlay();

        //end game
        endPlay();
    }
}
