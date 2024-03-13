package com.zervladpy.Entities.Converter;

import com.zervladpy.Utils.Enums.PaymentStatus;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class PaymentStatusConverter implements AttributeConverter<PaymentStatus, String> {
    @Override
    public String convertToDatabaseColumn(PaymentStatus attribute) {
        if (attribute == null) return null;

        return attribute.getAlias();
    }

    @Override
    public PaymentStatus convertToEntityAttribute(String dbData) {
        return PaymentStatus.fromAlias(dbData);
    }
}
