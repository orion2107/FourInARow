package Dao;

import Controller.Game;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;


public class RamGameDao implements Dao<Game> {

    private Map<Long, Game> gameMap;

    public RamGameDao() {
        this.gameMap = new HashMap<Long, Game>();
    }


    public Game get(Long id) {
        return gameMap.get(id);
    }

    public Collection<Game> getAll() {
        return gameMap.values();
    }

    public void save(Game game) {
        gameMap.put(game.getGameId(),game);
    }

    public void update(Game game, String[] params) {
        gameMap.put(game.getGameId(), game);
    }

    public void delete(Game game) {
        gameMap.remove(game.getGameId());
    }

    public Long getNextFreeGameId() {
        return Long.valueOf(gameMap.size());
    }


}
