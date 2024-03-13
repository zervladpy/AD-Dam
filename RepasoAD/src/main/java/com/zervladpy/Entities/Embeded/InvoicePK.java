package com.zervladpy.Entities.Embeded;

import com.zervladpy.Entities.Car;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

@AllArgsConstructor @NoArgsConstructor
@Getter @Setter
@Embeddable
public class InvoicePK implements Serializable {
    private String car;
    private Long person;
    private Long workshop;
    @Temporal(TemporalType.DATE)
    private LocalDate date;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        InvoicePK invoicePK = (InvoicePK) o;
        return Objects.equals(car, invoicePK.car) && Objects.equals(person, invoicePK.person) && Objects.equals(workshop, invoicePK.workshop) && Objects.equals(date, invoicePK.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(car, person, workshop, date);
    }
}
