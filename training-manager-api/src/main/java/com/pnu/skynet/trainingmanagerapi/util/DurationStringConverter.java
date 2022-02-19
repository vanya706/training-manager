package com.pnu.skynet.trainingmanagerapi.util;

import org.apache.commons.lang3.StringUtils;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.time.Duration;
import java.util.Objects;

@SuppressWarnings("unused")
@Converter(autoApply = true)
public class DurationStringConverter implements AttributeConverter<Duration, String> {

    @Override
    public String convertToDatabaseColumn(Duration attribute) {
        return Objects.toString(attribute, null);
    }

    @Override
    public Duration convertToEntityAttribute(String dbData) {
        if (StringUtils.isBlank(dbData)) {
            return null;
        }
        return Duration.parse(dbData);
    }

}
