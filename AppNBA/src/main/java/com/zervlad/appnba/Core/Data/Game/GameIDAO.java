package com.zervlad.appnba.Core.Data.Game;

import com.zervlad.appnba.Core.Data.Interfaces.IDAO;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;

import java.util.ArrayList;
import java.util.List;

public class GameDAO implements IDAO<GameEntity> {

    private final EntityManagerFactory entityManagerFactory;

    public GameDAO(EntityManagerFactory entityManagerFactory) {
        this.entityManagerFactory = entityManagerFactory;
    }

    @Override
    public void create(GameEntity entity) {

    }

    @Override
    public GameEntity getById(int id) {
        return null;
    }

    @Override
    public void update(GameEntity entity) {

    }

    @Override
    public void delete(GameEntity entity) {

    }

    @Override
    public void insertAll(List<GameEntity> entities) {

        try (EntityManager em = entityManagerFactory.createEntityManager()) {

            em.getTransaction().begin();

            for (GameEntity game : entities) {
                em.merge(game);
            }
            em.getTransaction().commit();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<GameEntity> getAll() {
        return new ArrayList<>();
    }

    @Override
    public void drop() {

    }
}
