package com.domain.ecommerce.conversors;

import com.domain.ecommerce.models.Colors;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class ColorsConverter implements AttributeConverter<Colors, String> {
    @Override
    public String convertToDatabaseColumn(Colors color) {
        if (color == null) return null;
        return color.getLabel();
    }

    @Override
    public Colors convertToEntityAttribute(String dbValue) {
        if (dbValue == null) return null;
        return Colors.fromLabel(dbValue);
    }
}
