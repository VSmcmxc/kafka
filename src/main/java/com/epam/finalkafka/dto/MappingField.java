package com.epam.finalkafka.dto;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Represents field, which can be mapped to entity(dto) instance.
 */
@Target(value = ElementType.FIELD)
@Retention(value = RetentionPolicy.RUNTIME)
public @interface MappingField {

    /**
     * Return Dto field for mapping.
     * It's possible not to set value if field names in mongo entity and dto are equal
     *
     * @return mongo field name
     */
    String value() default "";
}
