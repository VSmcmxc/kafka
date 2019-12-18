package com.epam.finalkafka.dto;

/**
 * Common entity interface.
 */
public interface Entity {
    /**
     * Returns entityId.
     *
     * @return value of entityId
     */
    EntityId getEntityId();

    /**
     * Sets entityId value.
     *
     * @param entityId - value to set
     */
    void setEntityId(EntityId entityId);
}
