package com.zervlad.tallerpaco.Core.DAO;

import com.zervlad.tallerpaco.Core.Entities.Parts.Part;
import jakarta.persistence.EntityManagerFactory;

public class PartDAO extends DAO<Part> {
    public PartDAO(EntityManagerFactory emf) {
        super(emf, Part.class);
    }
}
