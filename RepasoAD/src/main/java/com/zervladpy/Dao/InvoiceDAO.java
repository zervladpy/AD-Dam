package com.zervladpy.Dao;

import com.zervladpy.Entities.Car;
import com.zervladpy.Entities.DTOs.InvoiceDTO;
import com.zervladpy.Entities.DTOs.InvoiceDTOAddresses;
import com.zervladpy.Entities.Embeded.InvoicePK;
import com.zervladpy.Entities.Invoice;
import jakarta.persistence.EntityManager;

import java.util.List;

public class InvoiceDAO extends DAO<Invoice, InvoicePK> {
    public InvoiceDAO(EntityManager session, Class<Invoice> entityClass) {
        super(session, entityClass);
    }

    public List<Invoice> getByCar(Car car) {
        return getSession().createNamedQuery("getByCar", Invoice.class).setParameter("plate", car.getPlate()).getResultList();
    }

    public List<InvoiceDTO> getInvoicesForMyTable() {
        return getSession().createNamedQuery("getInvoiceDTOs", InvoiceDTO.class).getResultList();
    }

    public List<InvoiceDTOAddresses> getInvoiceAddresses() {

        String query = "select new com.zervladpy.Entities.DTOs.InvoiceDTOAddresses(" +
                "concat(p.address.city, ' ', p.address.country, ' ', p.address.street), " +
                "concat(w.address.city, ' ', w.address.country, ' ', w.address.street)) " +
                "from Invoice i left join i.person p left join i.workshop w";

        return getSession().createQuery(query, InvoiceDTOAddresses.class).getResultList();
    }

}
