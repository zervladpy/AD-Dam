package com.zervladpy.Entities;

import com.zervladpy.Entities.Embeded.Address;
import com.zervladpy.Utils.Interfaces.IEntity;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import java.util.Set;

import static jakarta.persistence.FetchType.LAZY;

@NoArgsConstructor @AllArgsConstructor
@Getter @Setter
@Entity @ToString
@Table(name ="workshop")
public class Workshop implements IEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @ElementCollection(fetch = LAZY)
    @CollectionTable(name = "workshop_phone", joinColumns = @JoinColumn(name = "workshop_id"))
    @Column(name = "workshop_phone")
    private Set<String> phone;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "country", column = @Column(name ="workshop_country")),
            @AttributeOverride(name = "city", column = @Column(name ="workshop_city")),
            @AttributeOverride(name = "street", column = @Column(name ="workshop_street")),
            @AttributeOverride(name = "zip", column = @Column(name ="workshop_zip"))
    })
    private Address address;

}
