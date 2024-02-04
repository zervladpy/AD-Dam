package org.zervladpy.daos;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import org.zervladpy.models.Coach;
import org.zervladpy.models.Team;

import java.util.ArrayList;
import java.util.List;

public class TeamDAO implements DAO<Team> {

    final EntityManager em;

    public TeamDAO(EntityManager em) {
        this.em = em;
    }

    @Override
    public Team getById(int id) {
        return em.find(Team.class, id);
    }

    @Override
    public List<Team> getAll() {
        return em.createQuery("select t from team t", Team.class).getResultList();
    }

    @Override
    public int insert(Team model) {
        em.getTransaction().begin();
        em.persist(model);
        em.getTransaction().commit();

        return model.getId();
    }

    @Override
    public int delete(Team model) {
        em.getTransaction().begin();
        em.remove(model);
        em.getTransaction().commit();

        return model.getId();
    }

    @Override
    public int update(Team model) {
        em.getTransaction().begin();
        em.merge(model);
        em.getTransaction().commit();

        return model.getId();
    }

    @Override
    public List<Integer> bunchInsert(List<Team> models) {

        List<Integer> ids = new ArrayList<>();

        em.getTransaction().begin();
        for(Team t : models) {
            em.persist(t);
            ids.add(t.getId());
        }
        em.getTransaction().commit();

        return ids;
    }
}
