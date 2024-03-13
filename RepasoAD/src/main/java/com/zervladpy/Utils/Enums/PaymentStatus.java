package com.zervladpy.Utils.Enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter @AllArgsConstructor
public enum PaymentStatus {
    PAYED("P"), NOT_PAYED("N");

    final String alias;

    static public PaymentStatus fromAlias(String alias) {
        return switch (alias) {
            case "P" -> PAYED;
            case "N" -> NOT_PAYED;
            default -> null;
        };
    }
}
