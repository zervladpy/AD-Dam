package com.zervladpy.Utils.JPA;

import jakarta.persistence.EntityManager;
import lombok.AllArgsConstructor;
import lombok.Getter;

public class JPAFactory {

    @Getter @AllArgsConstructor
    public enum JPAUnit {

        PRODUCTION("repaso"), TEST("repasoTest");

        private final String unit;

    }

    static public EntityManager createEntityManager(JPAUnit unit) {
        return JPAUtil.getEntityManager(unit.unit);
    };

}
