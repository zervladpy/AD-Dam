package com.zervlad.tallerpaco.Core.DAO;

import com.zervlad.tallerpaco.Core.Entities.Reciep.Receipt;
import jakarta.persistence.EntityManagerFactory;

public class ReceiptDAO extends DAO<Receipt> {
    public ReceiptDAO(EntityManagerFactory emf) {
        super(emf, Receipt.class);
    }
}
