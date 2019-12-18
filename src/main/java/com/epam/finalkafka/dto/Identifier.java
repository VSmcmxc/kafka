package com.epam.finalkafka.dto;

import java.io.Serializable;

/**
 * Entity identifier interface.
 *
 * @param <T> id type
 */
public interface Identifier<T> extends Serializable {

    /**
     * Returns id value.
     *
     * @return id value
     */
    T getId();
}
