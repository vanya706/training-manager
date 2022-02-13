package com.pnu.skynet.trainingmanagerapi.util;

import com.google.common.collect.Sets;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.util.HashSet;
import java.util.Set;

@Converter(autoApply = true)
public class StringSetConverter implements AttributeConverter<Set<String>, String> {

    @Override
    public String convertToDatabaseColumn(Set<String> values) {
        return CollectionUtils.isNotEmpty(values) ? String.join(",", values) : null;
    }

    @Override
    public Set<String> convertToEntityAttribute(String values) {
        return StringUtils.isNotBlank(values) ? Sets.newHashSet(values.split(",")) : new HashSet<>();
    }

}
