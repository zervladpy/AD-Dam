package org.zervladpy;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import org.zervladpy.daos.CoachDAO;
import org.zervladpy.daos.DAO;
import org.zervladpy.daos.TeamDAO;
import org.zervladpy.models.Coach;
import org.zervladpy.models.Team;
import org.zervladpy.utils.EntityManagerUtil;

public class Main {
    public static void main(String[] args) {

        final EntityManager entityManager = EntityManagerUtil.getEmfInstance().createEntityManager();

        final DAO<Team> teamDAO = new TeamDAO(entityManager);
        final DAO<Coach> coachDAO = new CoachDAO(entityManager);

        Team t1 = new Team("Equipo 1", "Santiago", "CF1", "Patata");

        teamDAO.insert(t1);

        Coach c1 = new Coach("Ivan", "10/20/2000", 20.0, t1);

        System.out.println(coachDAO.getById(c1.getId()));

        entityManager.close();
    }
}