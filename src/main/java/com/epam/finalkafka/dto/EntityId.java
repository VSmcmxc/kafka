package com.epam.finalkafka.dto;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import java.io.Serializable;

/**
 * Entity id interface.
 */
@JsonDeserialize(as = ObjectId.class)
public interface EntityId extends Identifier<String>, Serializable {
    /**
     * Returns id value.
     *
     * @return id value
     */
    String getId();
}
