package com.zervlad.tallerpaco.Core.Entities.Customer;

import com.zervlad.tallerpaco.Core.Entities.Car.Car;
import com.zervlad.tallerpaco.Core.Entities.Reciep.Receipt;
import com.zervlad.tallerpaco.Core.Entities.ITEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity(name = "customer")
public class Customer implements ITEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "name", nullable = false)
    private String name;
    @Column(name = "last_name", nullable = false)
    private String lastName;
    @Column(name = "email", nullable = false)
    private String email;
    @Column(name = "phone", nullable = false)
    private String phone;
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Car> cars;
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Receipt> receipts;

    public Customer() {
    }

    public Customer(int id, String name, String lastName, String email, String phone, List<Car> cars) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
        this.cars = cars;
    }
}
