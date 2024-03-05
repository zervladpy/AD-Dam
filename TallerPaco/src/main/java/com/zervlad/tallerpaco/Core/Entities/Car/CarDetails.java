package com.zervlad.tallerpaco.Core.Entities.Car;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;

@Getter@Setter
@Embeddable
public class CarDetails {
    @Column(name = "color")
    private String color;
    @Column(name = "license_plate")
    private String plate;
    @Column(name = "mileage")
    private int mileage;
}
