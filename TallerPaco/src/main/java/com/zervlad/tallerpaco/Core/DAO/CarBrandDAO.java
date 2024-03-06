package com.zervlad.tallerpaco.Core.DAO;

import com.zervlad.tallerpaco.Core.Entities.Car.CarBrand;
import jakarta.persistence.EntityManagerFactory;

public class CarBrandDAO extends DAO<CarBrand> {
    public CarBrandDAO(EntityManagerFactory emf) {
        super(emf, CarBrand.class);
    }
}
