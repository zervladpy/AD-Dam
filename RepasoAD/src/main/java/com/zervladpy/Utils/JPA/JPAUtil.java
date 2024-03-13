package com.zervladpy.Utils.JPA;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;
import jakarta.transaction.Transactional;

public class JPAUtil {
    static private EntityManager entityManagerInstance;

    private JPAUtil() {
    }

    static public EntityManager getEntityManager(String unit) {
        if (entityManagerInstance == null) {
            synchronized (EntityManager.class) {
                if (entityManagerInstance == null) {
                    entityManagerInstance = Persistence.createEntityManagerFactory(unit).createEntityManager();
                }
            }
        }

        return entityManagerInstance;
    }

    static public void closeEntityManager() {
        if (entityManagerInstance == null || !entityManagerInstance.isOpen()) {
            return;
        }

        entityManagerInstance.close();
    }

}
