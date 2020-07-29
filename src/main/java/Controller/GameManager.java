package Controller;


import Dao.GameProxyDao;
import Events.EventsEnum;
import Events.EventsHandler;
import Model.GameState;
import Model.Mode.GameMode;
import Utils.GameVerificator;

public class GameManager {

    private static GameManager gameManager = null;
    private GameProxyDao gameProxyDao;

    private GameManager() {

        gameProxyDao = new GameProxyDao();
    }

    public static GameManager getInstance() {
        if (gameManager == null) {
            synchronized (GameManager.class) {
                if (gameManager == null) {
                    gameManager = new GameManager();
                }
            }
        }
        return gameManager;
    }

    public GameProxyDao getGameProxyDao() {
        return gameProxyDao;
    }

    public void setPlayerMove(Long gameId, int colIndex) throws Exception {
        Game game = gameProxyDao.get(gameId);
        if (game != null && GameVerificator.verifyColumn(game.gameState.getBoard(), colIndex)) {
            game.setPlayerMove(colIndex);
        }
    }

    public GameState createNewGame(int gameMenuItem) throws Exception {
        GameMode gameMode = GameMode.values()[gameMenuItem];
        Long gameId = getNextFreeGameId();
//            Game game = (Game) DebugProxy.newInstance(new Game(gameMode, gameId));
        Game game = new Game(gameMode, gameId);
        game.initialize();
        gameProxyDao.save(game);
        return game.getGameState();

    }

    public void closeGame(Long gameId) {
        Game game = gameProxyDao.get(gameId);
        if (game != null)
            gameProxyDao.delete(game);
//        DebugProxy.close_inner_file();
    }

    private Long getNextFreeGameId() {
        return gameProxyDao.getNextFreeGameId();
    }
}
