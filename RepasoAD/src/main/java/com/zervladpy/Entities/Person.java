package com.zervladpy.Entities;

import com.zervladpy.Entities.Embeded.Address;
import com.zervladpy.Utils.Interfaces.IEntity;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import java.util.Set;

@NoArgsConstructor @AllArgsConstructor
@Getter @Setter
@Entity @ToString
@Table(name = "person")
public class Person implements IEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name ="name", length = 25)
    private String name;

    @Column(name ="surname", length = 50)
    private String surname;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "country", column = @Column(name = "person_country")),
            @AttributeOverride(name = "city", column = @Column(name = "person_city")),
            @AttributeOverride(name = "street", column = @Column(name = "person_street")),
            @AttributeOverride(name = "zip", column = @Column(name = "person_zip"))
    })
    private Address address;

    @ElementCollection(fetch = FetchType.LAZY)
    @CollectionTable(name ="person_phone", joinColumns = @JoinColumn(name = "person_id"))
    @Column(name = "person_phone")
    private Set<String> phone;

}
