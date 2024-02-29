package com.zervlad.appnba.Core.Services.Jakarta;


import com.zervlad.appnba.Utils.Constraints.PersistenceNBAConstraints;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class EntityManagerNBA {

    static private EntityManagerFactory emf;

    static public EntityManagerFactory getEntityManager() {

        if (emf == null) {
            synchronized (EntityManagerFactory.class) {
                if (emf == null) {
                    emf = Persistence.createEntityManagerFactory(PersistenceNBAConstraints.PERSISTENCE_UNIT);
                }
            }
        }

        return emf;
    }

}
