package com.zervlad.tallerpaco.Core.DAO;

import com.zervlad.tallerpaco.Core.Entities.Car.Car;
import jakarta.persistence.EntityManagerFactory;

public class CarDAO extends DAO<Car>{
    public CarDAO(EntityManagerFactory emf) {
        super(emf, Car.class);
    }
}
