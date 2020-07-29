package Dao;


import Controller.Game;

import java.util.Collection;

public class GameProxyDao implements Dao<Game> {

    Dao currentDao;

    public GameProxyDao() {

    }

    public Dao getCurrentDao() {
        return currentDao;
    }

    public void setCurrentDao(Dao currentDao) {
        this.currentDao = currentDao;
    }

    public Game get(Long id) {
        return currentDao.get(id);
    }

    public Collection<Game> getAll() {
        return currentDao.getAll();
    }

    public void save(Game game) {
        currentDao.save(game);
    }

    public void update(Game game, String[] params) {
        currentDao.update(game, params);
    }

    public void delete(Game game) {
        currentDao.delete(game);
    }

    public Long getNextFreeGameId() {
        return currentDao.getNextFreeGameId();
    }
}
