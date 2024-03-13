package com.zervladpy.Entities;

import com.zervladpy.Entities.Converter.PaymentStatusConverter;
import com.zervladpy.Entities.Embeded.InvoicePK;
import com.zervladpy.Utils.Enums.PaymentStatus;
import com.zervladpy.Utils.Interfaces.IEntity;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.Remove;

import java.time.LocalDate;

import static jakarta.persistence.FetchType.LAZY;
import static jakarta.persistence.TemporalType.DATE;

@AllArgsConstructor @NoArgsConstructor
@Setter @Getter
@Entity @ToString
@Table(name = "invoice")
@NamedQuery(name="getInvoiceRecount", query = "select count(i) from Invoice i")
@NamedQuery(name="getInvoices", query = "select i from Invoice i")
@NamedQuery(name="getByCar", query = "select i from Invoice i where car.plate = :plate")
@NamedQuery(name="getByDate", query = "select i from Invoice i where i.date = :date")
@NamedQuery(name="getByPerson", query = "select i from Invoice i where person.id = :person")
@NamedQuery(name="getByWorkshop", query = "select i from Invoice i where workshop.id = :workshop")
@NamedQuery(name="getInvoiceDTOs", query = "select new com.zervladpy.Entities.DTOs.InvoiceDTO(" +
        "c.plate, concat(p.name, ' ', p.surname), w.name, i.date) from Invoice i " +
        "left join i.car c left join i.person p left join i.workshop w")
@IdClass(InvoicePK.class)
public class Invoice implements IEntity {

    @Id
    @ManyToOne(fetch = LAZY)
    private Car car;

    @Id
    @ManyToOne(fetch = LAZY)
    private Person person;

    @Id
    @ManyToOne(fetch = LAZY)
    private Workshop workshop;

    @Id
    @Temporal(DATE)
    private LocalDate date;

    @Column(name = "price", precision = 3, nullable = false)
    private double price;

    @Convert(converter = PaymentStatusConverter.class)
    private PaymentStatus paymentStatus;

}
