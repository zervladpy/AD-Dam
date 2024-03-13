package com.zervladpy.Entities.DTOs;

import lombok.*;

import java.time.LocalDate;

@AllArgsConstructor @NoArgsConstructor
@Getter @Setter @ToString
public class InvoiceDTO {
    private String carPlate;
    private String fullName;
    private String workshopName;
    private LocalDate date;
}
