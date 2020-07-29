package Dao;

import Controller.Game;
import Model.Mode.GameMode;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class RamGameDaoTest {

    @Test
    void get() {
        Game game = new Game(GameMode.PlayerVsPlayer,(long)1);
        RamGameDao ramGameDao  = new RamGameDao();
        ramGameDao.save(game);
        Assertions.assertEquals(game, ramGameDao.get((long)1));
    }

    @Test
    void save() {
        Game game = new Game(GameMode.PlayerVsPlayer,(long)1);
        RamGameDao ramGameDao  = new RamGameDao();
        ramGameDao.save(game);
        Assertions.assertEquals(game, ramGameDao.get((long)1));
    }

    @Test
    void update(){
        Game game = new Game(GameMode.PlayerVsPlayer,(long)1);
        RamGameDao ramGameDao  = new RamGameDao();
        ramGameDao.save(game);
        Game game2 = new Game(GameMode.PlayerVsPlayer,(long)2);
        //ramGameDao.update();

    }

    @Test
    void delete() {
        Game game = new Game(GameMode.PlayerVsPlayer,(long)1);
        RamGameDao ramGameDao  = new RamGameDao();
        ramGameDao.save(game);
        ramGameDao.delete(game);
        Assertions.assertTrue(ramGameDao.get((long)1) == null);
    }

    @Test
    void getNextFreeGameId() {
        Game game = new Game(GameMode.PlayerVsPlayer,(long)1);
        RamGameDao ramGameDao  = new RamGameDao();
        ramGameDao.save(game);
        Assertions.assertEquals(2, ramGameDao.getNextFreeGameId());
    }
}