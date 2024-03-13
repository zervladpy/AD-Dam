package com.zervladpy.Entities.Embeded;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor @AllArgsConstructor
@Getter @Setter
@Embeddable
public class Address {
    private String country;
    private String city;
    private String street;
    private String zip;
}
