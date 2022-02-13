package com.pnu.skynet.trainingmanagerapi.util;

import com.pnu.skynet.trainingmanagerapi.constant.BodyPart;

import javax.persistence.Converter;

@SuppressWarnings("unused")
@Converter(autoApply = true)
public class BodyPartConverter extends AbstractEnumConverter<BodyPart> {

    public BodyPartConverter() {
        super(BodyPart.class);
    }

}
