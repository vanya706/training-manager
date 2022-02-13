package com.pnu.skynet.trainingmanagerapi.util;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;

import javax.persistence.AttributeConverter;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@SuppressWarnings("com.haulmont.jpb.ConverterNotAnnotatedInspection")
public abstract class AbstractEnumConverter<T extends Enum<T>> implements AttributeConverter<Set<T>, String> {

    private final Class<T> enumClass;

    public AbstractEnumConverter(Class<T> enumClass) {
        this.enumClass = enumClass;
    }

    @Override
    public String convertToDatabaseColumn(Set<T> attribute) {
        if (CollectionUtils.isEmpty(attribute)) {
            return null;
        }
        return attribute.stream()
                .map(T::name)
                .collect(Collectors.joining(","));
    }

    @Override
    public Set<T> convertToEntityAttribute(String dbData) {
        if (StringUtils.isBlank(dbData)) {
            return new HashSet<>();
        }
        return Arrays.stream(dbData.split(","))
                .map(name -> Enum.valueOf(enumClass, name))
                .collect(Collectors.toSet());
    }

}
