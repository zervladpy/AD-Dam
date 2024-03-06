package com.zervlad.tallerpaco.Core.DAO;

import com.zervlad.tallerpaco.Core.Entities.Customer.Customer;
import jakarta.persistence.EntityManagerFactory;

import java.util.List;

public class CustomerDAO extends DAO<Customer>{
    public CustomerDAO(EntityManagerFactory emf) {
        super(emf, Customer.class);
    }


    @Override
    public List<Customer> getAll() {
        return super.getAll();
    }
}
