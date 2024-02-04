package org.zervladpy.daos;

import jakarta.persistence.EntityManager;
import org.zervladpy.models.Coach;

import java.util.ArrayList;
import java.util.List;

public class CoachDAO implements DAO<Coach> {

    final EntityManager em;

    public CoachDAO(EntityManager em) {
        this.em = em;
    }

    @Override
    public Coach getById(int id) {
        return em.find(Coach.class, id);
    }

    @Override
    public List<Coach> getAll() {
        return em.createQuery("select c from coach c", Coach.class).getResultList();
    }

    @Override
    public int insert(Coach model) {

        em.getTransaction().begin();
        em.persist(model);

        em.getTransaction().commit();

        return model.getId();
    }

    @Override
    public int delete(Coach model) {

        em.getTransaction().begin();
        em.remove(model);
        em.getTransaction().commit();

        return model.getId();
    }

    @Override
    public int update(Coach model) {

        em.getTransaction().begin();
        em.merge(model);
        em.getTransaction().commit();

        return model.getId();
    }

    @Override
    public List<Integer> bunchInsert(List<Coach> models) {

        List<Integer> ids = new ArrayList<>();

        em.getTransaction().begin();
        for(Coach coach : models) {
            em.persist(coach);
            ids.add(coach.getId());
        }
        em.getTransaction().commit();

        return ids;
    }
}
