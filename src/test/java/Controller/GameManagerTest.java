package Controller;

import Dao.RamGameDao;
import Model.Mode.GameMode;
import org.junit.BeforeClass;
import org.junit.ClassRule;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GameManagerTest {

    private Exception exception;
    @ClassRule
    RamGameDao ramGameDao = new RamGameDao();
    GameManager gameManager = GameManager.getInstance();

    @BeforeClass
    void init(){
        gameManager.getGameProxyDao().setCurrentDao(ramGameDao);
    }

    @Test
    void getInstance() {
        Assertions.assertEquals(gameManager, GameManager.getInstance());
    }

    @Test
    void getGameProxyDao() {
        init();
        Assertions.assertEquals(ramGameDao, gameManager.getGameProxyDao().getCurrentDao());
    }

    @Test
    void setPlayerMove() {
        init();
        try {
            gameManager.createNewGame(GameMode.PlayerVsPlayer.ordinal());
            gameManager.setPlayerMove((long)0,0);
        }
        catch(Exception e){
            System.out.println("Test closeGame has finished with an exception e:" + e);
            return;
        }
        /////////////Dont know if need ot not to test//////////////////// and how? :(

    }

    @Test
    void createNewGame() {
        init();
        Throwable exception = Assertions.assertThrows(IndexOutOfBoundsException.class,()->
                assertEquals("Not valid input, please choose again",
                 gameManager.createNewGame((int)6)));

    }

    @Test
    void closeGame() {
        init();
        try {
            gameManager.createNewGame(GameMode.PlayerVsPlayer.ordinal());
        }
        catch(Exception e){
            System.out.println("Test closeGame has finished with an exception e:" + e);
            return;
        }
        gameManager.closeGame((long)0); //first game
        Assertions.assertTrue(gameManager.getGameProxyDao().getCurrentDao().get(Long.valueOf(0)) == null);

    }
}