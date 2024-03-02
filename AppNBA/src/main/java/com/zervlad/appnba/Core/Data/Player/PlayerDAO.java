package com.zervlad.appnba.Core.Data.Player;

import com.zervlad.appnba.Core.Interfaces.DAO;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;

public class PlayerDAO implements DAO<PlayerEntity> {

    private final EntityManagerFactory entityManagerFactory;

    public PlayerDAO(EntityManagerFactory entityManagerFactory) {
        this.entityManagerFactory = entityManagerFactory;
    }

    @Override
    public void create(PlayerEntity entity) {

        EntityManager em = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = em.getTransaction();

        transaction.begin();

        em.persist(entity);

        transaction.commit();

        em.close();
    }

    @Override
    public PlayerEntity getById(int id) {
        return null;
    }

    @Override
    public void update(PlayerEntity entity) {

        EntityManager em = entityManagerFactory.createEntityManager();

        EntityTransaction transaction = em.getTransaction();

        transaction.begin();

        em.merge(entity);

        transaction.commit();

        em.close();

    }

    @Override
    public void delete(PlayerEntity entity) {

        EntityManager em = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = em.getTransaction();

        transaction.begin();

        em.remove(entity);

        transaction.commit();

        em.close();

    }

    @Override
    public void insertAll(PlayerEntity[] entities) {

        try (var em = entityManagerFactory.createEntityManager()) {

            var transaction = em.getTransaction();

            transaction.begin();

            for (PlayerEntity player : entities) {

                em.persist(player);
            }

            transaction.commit();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public PlayerEntity[] getAll() {

        EntityManager em = entityManagerFactory.createEntityManager();

        return new PlayerEntity[0];
    }

    @Override
    public void drop() {

        EntityManager em = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = em.getTransaction();

        transaction.begin();

        em.createQuery("DELETE FROM PlayerEntity").executeUpdate();

        transaction.commit();

        em.close();
    }
}
