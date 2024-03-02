package com.zervlad.appnba.Core.Data.Team;

import com.zervlad.appnba.Core.Interfaces.DAO;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;

public class TeamDAO implements DAO<TeamEntity> {

    private final EntityManagerFactory entityManager;

    public TeamDAO(EntityManagerFactory entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public void create(TeamEntity entity) {

        EntityManager em = entityManager.createEntityManager();
        EntityTransaction transaction = em.getTransaction();

        transaction.begin();

        em.persist(entity);

        transaction.commit();

        em.close();
    }

    @Override
    public TeamEntity getById(int id) {

        EntityManager em = entityManager.createEntityManager();

        TeamEntity team = em.find(TeamEntity.class, id);

        em.close();

        return team;

    }

    @Override
    public void update(TeamEntity entity) {

        EntityManager em = entityManager.createEntityManager();

        EntityTransaction transaction = em.getTransaction();

        transaction.begin();

        em.merge(entity);

        transaction.commit();

        em.close();

    }

    @Override
    public void delete(TeamEntity entity) {

        EntityManager em = entityManager.createEntityManager();
        EntityTransaction transaction = em.getTransaction();

        transaction.begin();

        em.remove(entity);

        transaction.commit();

        em.close();

    }

    @Override
    public void insertAll(TeamEntity[] entities) {

        EntityManager em = entityManager.createEntityManager();
        EntityTransaction transaction = em.getTransaction();

        transaction.begin();

        for (TeamEntity team : entities) {
            System.out.println("Inserting team: " + team.getName());
            em.persist(team);
        }

        transaction.commit();

        em.close();

    }

    @Override
    public TeamEntity[] getAll() {

        return new TeamEntity[0];
    }

    @Override
    public void drop() {
        EntityManager em = entityManager.createEntityManager();

        em.getTransaction().begin();

        em.createQuery("DELETE FROM TeamEntity").executeUpdate();

        em.getTransaction().commit();

        em.close();
    }

}
