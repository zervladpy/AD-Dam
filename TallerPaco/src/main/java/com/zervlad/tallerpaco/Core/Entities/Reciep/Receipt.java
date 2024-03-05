package com.zervlad.tallerpaco.Core.Entities.Reciep;

import com.zervlad.tallerpaco.Core.Entities.Customer.Customer;
import com.zervlad.tallerpaco.Core.Entities.Parts.Part;
import com.zervlad.tallerpaco.Core.Entities.ITEntity;
import com.zervlad.tallerpaco.Core.Utils.Enums.ServiceType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@Entity(name = "receipt")
public class Receipt implements ITEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "date")
    private LocalDate receiptDate;
    @ManyToOne
    @JoinColumn(name = "customer_id", referencedColumnName = "id")
    private Customer customer;
    @Enumerated(EnumType.STRING)
    @Column(name = "service_type")
    private ServiceType serviceType;
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "receipt_id", referencedColumnName = "id")
    private List<Part> parts;
    @Column(name = "labor_price")
    private double laborPrice;
    @Column(name = "total")
    private double total;

    public Receipt() {
    }
    public Receipt(int id, LocalDate receiptDate, Customer customer, ServiceType serviceType, List<Part> parts, double laborPrice, double total) {
        this.id = id;
        this.receiptDate = receiptDate;
        this.customer = customer;
        this.serviceType = serviceType;
        this.parts = parts;
        this.laborPrice = laborPrice;
        this.total = total;
    }
}
