package com.pepinho.programacion.biblioteca.model;

import com.pepinho.programacion.biblioteca.model.H2.BookH2DAO;
import com.pepinho.programacion.biblioteca.model.Hibernate.BookHibernateDAO;

public class DAOFactory {

    private EntityManagerUtil managerUtil;

    public DAOFactory(EntityManagerUtil entityManagerUtil) {
        managerUtil = entityManagerUtil;
    }

    public enum Provider {
        H2, HIBERNATE
    }

    public DAO<Book> getBookDAO(Provider provider) {
        return switch (provider) {
            case H2 -> new BookH2DAO(managerUtil.getConnection());
            case HIBERNATE -> new BookHibernateDAO(managerUtil.getEntityManagerFactory());
        };
    }

}
