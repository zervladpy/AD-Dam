package com.zervlad.appnba.Core.Services;


import com.zervlad.appnba.Utils.Constraints.PersistenceNBAConstraints;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class EntityManagerNBA {

    static private EntityManagerFactory emf;

    static public EntityManagerFactory getEntityManagerFactory() {

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
