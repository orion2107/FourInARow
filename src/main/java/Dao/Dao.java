package Dao;


import Controller.Game;

import java.util.Collection;


public interface Dao<T> {

        Game get(Long id);

        Collection<T> getAll();

        void save(T t);

        void update(T t, String[] params);

        void delete(T t);

        Long getNextFreeGameId();
}
