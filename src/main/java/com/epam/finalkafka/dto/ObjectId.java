package com.epam.finalkafka.dto;


import javax.validation.constraints.Pattern;
import java.util.Objects;

/**
 * Object id class.
 */
public class ObjectId implements EntityId {
    @Pattern(regexp = ValidationExpressions.OBJECT_ID_REGEX)
    private final String id;

    public ObjectId() {
        this.id = null;
    }

    private ObjectId(String id) {
        this.id = id;
    }

    /**
     * Creates id instance.
     *
     * @param id value
     * @return entityId instance
     */
    public static final EntityId getInstance(String id) {
        // regex check
        return new ObjectId(id);
    }

    /**
     * Returns id instance.
     *
     * @return id value
     */
    @Override
    public String getId() {
        return id;
    }


    /**
     * Equals realisation.
     *
     * @param o object
     * @return boolean
     * @see Object
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ObjectId objectId = (ObjectId) o;
        return Objects.equals(getId(), objectId.getId());
    }

    /**
     * Hashcode realisation.
     *
     * @return int
     * @see Object
     */
    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
