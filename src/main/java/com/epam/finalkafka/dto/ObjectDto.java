package com.epam.finalkafka.dto;


import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.Objects;


/**
 * Abstract DTO class contains entityId.
 */
public abstract class ObjectDto implements Entity {
    @MappingField("id")
    private  EntityId entityId;

    /**
     * Returns entityId.
     *
     * @return value of entityId
     */
    @Override
    public EntityId getEntityId() {
        return entityId;
    }

    /**
     * Sets entityId value.
     *
     * @param entityId - value to set
     */
    @Override
    public void setEntityId(EntityId entityId) {
        this.entityId = entityId;
    }

    /**
     * Checks is dto new.
     *
     * @return true or false
     */
    @JsonIgnore
    public boolean isNew() {
        return entityId == null || entityId.getId() == null;
    }

    /**
     * Checks that current object equal to some object.
     *
     * @param o object to check
     * @return true if equals, false if not
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ObjectDto objectDto = (ObjectDto) o;
        return Objects.equals(entityId, objectDto.entityId);
    }

    /**
     * Returns hash code.
     *
     * @return hash code
     */
    @Override
    public int hashCode() {
        return Objects.hash(entityId);
    }
}
