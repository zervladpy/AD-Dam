package com.zervlad.appnba.Core.Data.Game;

import com.zervlad.appnba.Core.Interfaces.DAO;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;

public class GameDAO implements DAO<GameEntity> {

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
    public void insertAll(GameEntity[] entities) {

        try (EntityManager em = entityManagerFactory.createEntityManager()) {

            em.getTransaction().begin();

            for (GameEntity game : entities) {
                em.persist(game);
            }
            em.getTransaction().commit();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public GameEntity[] getAll() {
        return new GameEntity[0];
    }

    @Override
    public void drop() {

    }
}
