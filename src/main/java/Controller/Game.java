package Controller;


import Model.Board;
import Model.GameState;
import Model.Mode.GameLevel;
import Model.Mode.GameMode;
import Model.Player.PlayerEnum;
import Model.Player.PlayerFactory;
import Strategy.GameStrategy.GameStrategy;
import Strategy.GameStrategy.GameStrategyFactory;
import Utils.Constants;

public class Game extends GameTemplate{
    protected Long gameId;
    protected GameMode gameMode;
    protected GameState gameState;
    private GameStrategy gameStrategy;

    //-----------------------Constructor---------------------------
    public Game(GameMode gameMode, Long gameId){
        this.gameMode = gameMode;
        this.gameId = gameId;
    }

    public void setGameLevel(int gameLevelInt) {
        getGameState().setGameLevel(GameLevel.values()[gameLevelInt]);

    }

    public Long getGameId() {
        return gameId;
    }

    //----------------------Public Methods-------------------------
    @Override
    public void initialize() {
        gameState = new GameState(gameId, gameMode);
        setGameStrategy();
        createBoard();
        createPlayers();
        startPlay();
    }

    @Override
    public void startPlay() {
        System.out.println("Game Started");
    }

    @Override
    public void endPlay() { //Do we want to pass here the ID of the player?
        System.out.println("End");
    }

    private void setGameStrategy() {
        GameStrategyFactory gameStrategyFactory = new GameStrategyFactory();
        this.gameStrategy = gameStrategyFactory.getGameStrategy(gameMode);
    }

    public void createPlayers(){
        //TODO: Need to chose if he wants to play with a computer hardcoded or 2 players
        PlayerFactory playerFactory = new PlayerFactory();
        //initializing players meanwhile we have human and a regular player as a demo
        switch (gameMode) {
            case PlayerVsComp:
                gameState.addPlayer(playerFactory.getPlayer(PlayerEnum.Human, Constants.FIRST_PLAYER_ID));
                gameState.addPlayer(playerFactory.getPlayer(PlayerEnum.Computer, Constants.SECOND_PLAYER_ID));
                break;
            case PlayerVsPlayer:
                gameState.addPlayer(playerFactory.getPlayer(PlayerEnum.Human, Constants.FIRST_PLAYER_ID));
                gameState.addPlayer(playerFactory.getPlayer(PlayerEnum.Human, Constants.SECOND_PLAYER_ID));
                break;
//            case ComputerVsComputer:
//                gameState.addPlayer(playerFactory.getPlayer(PlayerEnum.Computer, Constants.FIRST_PLAYER_ID));
//                gameState.addPlayer(playerFactory.getPlayer(PlayerEnum.Computer, Constants.SECOND_PLAYER_ID));
//                break;
        }
    }

    public void createBoard(){
        //Future - add options to define the board space
        Board board = new Board(8,8,4);
//        Board board = (Board) DebugProxy.newInstance(new Board(8,8,4));
        gameState.setBoard(board);
    }

    public void setPlayerMove (int colIndex) {
        gameStrategy.setPlayerMove(gameState, colIndex);
    }

    public GameState getGameState() {
        return gameState;
    }

}
