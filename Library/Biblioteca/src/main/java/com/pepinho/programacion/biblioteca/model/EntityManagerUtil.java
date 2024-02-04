/*
 * Autor: Pepe Calo
 * Realizado con fines educativos.
 * Puede modificarlo siempre que no lo haga con fines comerciales.
 */
package com.pepinho.programacion.biblioteca.model;

import com.pepinho.programacion.biblioteca.Constraints;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author pepecalo
 */
public class EntityManagerUtil {

    public static final String URL = "jdbc:h2:D:" + Constraints.DB_PATH + ";DB_CLOSE_ON_EXIT=TRUE;DATABASE_TO_UPPER=FALSE;FILE_LOCK=NO";

    public static final String DRIVER = "org.h2.Driver";

    private static EntityManagerUtil instance;

    private Connection conexion;
    private EntityManagerFactory entityManagerFactory;

    private EntityManagerUtil() {

    }

    public static EntityManagerUtil getInstance() {
        if (instance == null) {
            // esperas ti e eu
            synchronized (EntityManagerUtil.class) {
                if (instance == null) {
                    instance = new EntityManagerUtil();
                }
            }
        }
        return instance;
    }

    public Connection getConnection() {
        try {
            if (conexion == null || conexion.isClosed()) {
                synchronized (EntityManagerUtil.class) {
                    if (conexion == null) {
                        try {
                            Class.forName(DRIVER);
                            conexion = DriverManager.getConnection(URL);
                        } catch (ClassNotFoundException ex) {
                            System.err.println("Drivers non atopados.");
                        } catch (SQLException ex) {
                            System.err.println("Erro ó establecer a conexión: "
                                    + ex.getMessage());
                        }
                    }
                }
            }
        } catch (SQLException e) {
            System.err.println("Erro ó establecer a conexión: "
                    + e.getMessage());
        }
        return conexion;
    }

    public EntityManagerFactory getEntityManagerFactory() {
        if (entityManagerFactory == null || !entityManagerFactory.isOpen()) {
            synchronized (EntityManagerUtil.class) {
                if (entityManagerFactory == null) {
                    entityManagerFactory = Persistence.createEntityManagerFactory("biblioteca");
                }
            }
        }
        return entityManagerFactory;
    }

}
