package org.zervladpy.utils;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

/**
 *
 * */
public class EntityManagerUtil {

    /**
     *
     * */
    private static volatile EntityManagerFactory emfInstance;

    /**
     *
     * */
    private EntityManagerUtil() {}

    /**
     *
     * */
    public static EntityManagerFactory getEmfInstance() {
        if (emfInstance == null) {
            synchronized (EntityManagerUtil.class) {
                if (emfInstance == null) {
                    emfInstance = Persistence.createEntityManagerFactory("nba");
                }
            }
        }

        return emfInstance;
    }
}
