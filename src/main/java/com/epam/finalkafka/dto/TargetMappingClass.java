package com.epam.finalkafka.dto;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Represents mongo entity class in which can be mapped current DTO.
 */
@Target(value = ElementType.TYPE)
@Retention(value = RetentionPolicy.RUNTIME)
public @interface TargetMappingClass {

    /**
     * Return mongo entity class for mapping.
     *
     * @return mongo entity classname
     */
    String value();
}
