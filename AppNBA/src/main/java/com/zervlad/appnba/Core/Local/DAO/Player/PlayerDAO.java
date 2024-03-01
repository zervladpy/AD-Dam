package com.zervlad.appnba.Core.Local.DAO.Player;

import com.zervlad.appnba.Core.Local.DAO.DAO;
import com.zervlad.appnba.Core.Local.Entities.Player;

public abstract class PlayerDAO implements DAO<Player> {

    public abstract PlayerDAO createDAO();
}
