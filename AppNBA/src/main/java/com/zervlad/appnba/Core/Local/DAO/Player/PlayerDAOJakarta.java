package com.zervlad.appnba.Core.Local.DAO.Player;

import com.zervlad.appnba.Core.Local.Entities.Player;

public class PlayerDAOJakarta extends PlayerDAO {
    @Override
    public Player create(Player entity) {
        return null;
    }

    @Override
    public Player read(int id) {
        return null;
    }

    @Override
    public Player update(Player entity) {
        return null;
    }

    @Override
    public void delete(Player entity) {

    }

    @Override
    public PlayerDAO createDAO() {
        return new PlayerDAOJakarta();
    }
}
