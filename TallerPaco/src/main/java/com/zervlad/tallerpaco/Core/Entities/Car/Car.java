package com.zervlad.tallerpaco.Core.Entities.Car;

import com.zervlad.tallerpaco.Core.Entities.Customer.Customer;
import com.zervlad.tallerpaco.Core.Entities.ITEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "car")
public class Car implements ITEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Embedded
    private CarDetails details;
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "owner_id", referencedColumnName = "id")
    private Customer customer;
    @ManyToOne
    @JoinColumn(name = "brand_id", referencedColumnName = "id")
    private CarBrand carBrand;

    public Car() {
    }

    public Car(int id, CarDetails details, Customer customer, CarBrand carBrand) {
        this.id = id;
        this.details = details;
        this.customer = customer;
        this.carBrand = carBrand;
    }


}
