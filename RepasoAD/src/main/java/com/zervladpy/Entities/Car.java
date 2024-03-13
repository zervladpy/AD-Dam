package com.zervladpy.Entities;

import com.zervladpy.Utils.Interfaces.IEntity;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

import static jakarta.persistence.CascadeType.ALL;
import static jakarta.persistence.FetchType.EAGER;
import static jakarta.persistence.FetchType.LAZY;

@NoArgsConstructor @AllArgsConstructor
@Setter @Getter
@Entity @ToString
@Table(name = "car")
public class Car implements IEntity {
    @Id
    @Column(length = 7)
    private String plate;

    @Column(name = "color")
    private String color;

}
