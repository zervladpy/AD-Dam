package com.zervlad.tallerpaco.Core.Entities.Parts;

import com.zervlad.tallerpaco.Core.Entities.ITEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "part")
public class Part implements ITEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "name", nullable = false)
    private String reference;
    @Column(name = "description", nullable = false)
    private String description;
    @Column(name = "price", nullable = false)
    private double price;
    @Column(name = "stock", nullable = false)
    private int stock;

    public Part() {
    }

    public Part(int id, String reference, String description, double price, int stock) {
        this.id = id;
        this.reference = reference;
        this.description = description;
        this.price = price;
        this.stock = stock;
    }
}
